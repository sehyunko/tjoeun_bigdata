###### 1. 데이터 구조 변경 (melt, cast함수)######

head(airquality)

install.packages("reshape2")
library(reshape2)

airquality.melt <- melt(airquality, id=c('Month','Day'), value.name='value',variable.name = 'variable',na.rm = TRUE) ##na.rm=TRUE -> value가 NA인 부분은 다 날리기 
head(airquality.melt) 


# melt를 통해 바뀐 구조 (5월5일 데이터)
subset(airquality, Month==5&Day==5)
subset(airquality.melt, Month==5&Day==5)

# melt된 데이터를 원상복구 : dcast vs. acast 

airquality.dc <- dcast(airquality.melt, Month+Day ~ variable)
head(airquality.dc, 2)
head(airquality,2)

airquality.ac <- acast(airquality.melt, Month+Day ~ variable)
head(airquality.ac, 2)

airquality.ac['5_1',]

#############################################
########## 데이터 구조 변경 예 ##############
#############################################

df1 <- read.csv("D:\\BigData\\Download\\13_R\\sharedBigdata\\전국 평균 평당 분양가격(2013년 9월부터 2015년 8월까지).csv")

df2 <- read.csv("D:\\BigData\\Download\\13_R\\sharedBigdata\\주택도시보증공사_전국 신규 민간아파트 분양가격 동향_20210531.csv")

## df1 테이블 구조 변경

View(head(df1))
View(head(df2))

df1_new <- melt(df1, id="지역",variable.name="날짜",value.name="분양가")

df1_new$연도 <- as.integer(substr(df1_new$날짜,2,5))  ## '년' 기준으로 strsplit 을 하고 앞뒤 몇자리 씩 취하는 것도 방법임 

monthStr <- strsplit(as.character(df1_new$날짜),split='년')[[1]][2] 
monthStr <- substr(monthStr,1,nchar(monthStr)-1)
df1_new$달 <-as.integer(monthStr)

names(df1_new) <- c('location','date','rate','year','month')
df1_new <- subset(df1_new, select=-c(date))
View(tail(df1_new))

## df2 테이블 구조 변경 

View(head(df2))

df2 <- df2[df2$규모구분 == "모든면적",]

df2$규모구분 <- NULL 

head(df2)

str(df2)

names(df2) <- c('location','year','month','rate.per.meter.sqaured')

df2$rate.per.meter.sqaured <- as.integer(df2$rate.per.meter.sqaured) ## 형변환

colSums(is.na(df2)) ## 빈 스트링 정ㅅ형으로 변환 불가한것은 NA처리 

df2$rate <- df2$rate.per.meter.sqaured *3.3

df2 <- subset(df2,select=-c(rate.per.meter.sqaured))

head(df1_new,2)

head(df2,2)

df <- rbind(df1_new,df2)
