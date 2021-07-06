# 분석 도전
# • 미국 동북중부 437개 지역의 인구통계 정보를 담고 있는 midwest 데이터를 사용해
# 데이터 분석 문제를 해결해 보세요. midwest는 ggplot2 패키지에 들어 있습니다.
library(ggplot2)
library(dplyr)
midwest <- as.data.frame(midwest)

# • 문제1. popadults는 해당 지역의 성인 인구, poptotal은 전체 인구를 나타냅니다. 
# midwest 데이터에 '전체 인구 대비 미성년 인구 백분율' 변수를 추가하세요.
midwest <- midwest %>% 
            mutate(children_percent = (poptotal-popadults)/poptotal)


# • 문제2. 미성년 인구 백분율이 가장 높은 상위 5개 county(지역)의 미성년 인구
# 백분율을 출력하세요.
midwest %>% 
  arrange(-children_percent) %>%
  select(county,children_percent) %>% 
  head(5)

# • 문제3. 분류표의 기준에 따라 미성년 비율 등급 변수를 추가하고, 각 등급에 몇 개의
# 지역이 있는지 알아보세요.

midwest[midwest$children_percent>=0.4,'grade'] <- 'Large'
midwest[midwest$children_percent>=0.3 | midwest$children_percent<0.4,'grade'] <-'Middle'
midwest[midwest$children_percent<0.3,'grade'] <- 'Small'

# • 문제4. popasian은 해당 지역의 아시아인 인구를 나타냅니다. '전체 인구 대비
# 아시아인 인구 백분율' 변수를 추가하고, 하위 10개 지역의 state(주), 
# county(지역명), 아시아인 인구 백분율을 출력하세요

midwest %>% 
  mutate(asian_pop_percent = popasian/poptotal) %>% 
  arrange(asian_pop_percent) %>% 
  select(county,asian_pop_percent) %>% 
  head(10)


# 혼자서 해보기6. mpg 데이터를 이용해서 분석 문제를 해결해 보세요.
# • 우선 mpg 데이터를 불러와서 일부러 이상치를 만들겠습니다. drv(구동
# 방식) 변수의 값은 4(사륜구동), f(전륜구동), r(후륜구동) 세 종류로 되어
# 있습니다. 몇 개의 행에 존재할 수 없는 값 k를 할당하겠습니다. 

mpg <- as.data.frame(ggplot2::mpg) # mpg 데이터 불러오기
mpg[c(10, 14, 58, 93), "drv"] <- "k" # drv 이상치 할당
mpg[c(29, 43, 129, 203), "cty"] <- c(3, 4, 39, 42) # cty 이상치 할당 



# • 이상치가 들어있는 mpg 데이터를 활용해서 문제를 해결해보세요.
# • 구동방식별로 도시 연비가 다른지 알아보려고 합니다. 분석을 하려면
# 우선 두 변수에 이상치가 있는지 확인하려고 합니다.

# • Q1. drv에 이상치가 있는지 확인하세요. 이상치를 결측 처리한 다음
# 이상치가 사라졌는지 확인하세요. 결측 처리 할 때는 %in% 기호를
# 활용하세요.
mpg[mpg$drv %in% 'k','drv'] <- NA
table(mpg$drv)

mpg <- mpg[!is.na(mpg$drv),]  ## 이상치 있는 항 제거

sum(is.na(mpg$drv))

# • Q2. 상자 그림을 이용해서 cty에 이상치가 있는지 확인하세요. 상자
# 그림의 통계치를 이용해 정상 범위를 벗어난 값을 결측 처리한 후 다시
# 상자 그림을 만들어 이상치가 사라졌는지 확인하세요.
outlier <- boxplot(mpg$cty)$stats

mpg[mpg$cty < outlier[1],'cty'] <- median(mpg$cty, na.rm=TRUE)
mpg[mpg$cty > outlier[5],'cty'] <- median(mpg$cty, na.rm=TRUE)

boxplot(mpg$cty)

# • Q3. 두 변수의 이상치를 결측처리 했으니 이제 분석할 차례입니다. 이상
# 치를 제외한 다음 drv별로 cty 평균이 어떻게 다른지 알아보세요. 하나의 dplyr 구문으로 만들어야 합니다
mpg %>% 
  group_by(drv) %>% 
  summarise(cty_mean = mean(cty))




