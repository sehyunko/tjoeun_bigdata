#### 6장.데이터 시각화 #### 


## 1. Base Graphing System 

library(ggplot2)

## 1-1. 고수준 함수 그래프 

#(1) plot 

plot(mtcars$wt, mtcars$mpg, xlab='Weight',ylab='Miles per Hour', main='Weight Vs. Mileage')
fit <- lm(mpg ~ wt, data=mtcars)
lines(mtcars$wt,fit$coefficients[1]+fit$coefficients[2]*mtcars$wt, col='red', lty='dashed')

abline(fit) ## 회귀 적합 모델 객체만 넣어주면 알아서 적합선을 그림 


## 점과 선을 그리는 타입 지정 하기
oldPar <- par(mfrow=c(3,2))

plot(cars, type="p",main="p-type") ## type="p" 일반적인 산점도 그래프 
plot(cars, type="l",main="l-type") ## 추세선 
plot(cars, type="b",main="b-type") ## 추세선 각 지점에 데이터 포인트들을 추가 
plot(cars, type="s",main="s-type") ## 계단 그래프 
plot(cars, type="n",main="n-type") ## 안보임 그냥냥
plot(cars, type="o",main="o-type") ## b type과 유사하나 그래프 선과 점들이 겹치지 않음 

par(oldPar)


#(2) boxplot 

boxplot(mtcars$mpg, main='Miles per Hour Distiribution')

boxplot(mtcars$mpg ~ mtcars$gear) ## A ~ B : A를 B 그룹에 따라 그리기 

#(3) par() : 그래프 파라미터 


##그리드 레이아웃 설정 
oldPar <- par(mfrow=c(2,2))
plot(cars)
plot(cars)
plot(cars)
plot(cars)

plot(iris) ## iris 변수들간의 상관도 그래프를 그려준다. 

par(oldPar) ## 설정 초기화 

##마진 설정 
opar <- par(mar=c(5,2,5,2)) ## 여백 하,좌,상,우 순으로. 시계방향. 

x<-1:100
y<- rnorm(100) 
plot(x,y,pch=23,type="b",col="blue",bg="green",ylim=c(-5,5),main='scatter plot')
## yaxt ="n"-> y의 눈금 좌표를 다 없앰
## bty ="n" -> 박스 테두리를 없앰 

axis(side=2, at=c(-2,0,2),col='red')
# side: 1하, 2좌, 3상, 4우 
# at 축과 눈금이 그려질 위치 
mtext('red line', side=2, line=2,at=0,col=2)

## new 옵션 설정 (덮어 씌워 그리기)
opar <- par(new=TRUE)
set.seed(100)
x <- 1:100
y1<- rnorm(x)
y2<- rnorm(x)+100 

plot(x,y1,col='red',xaxt='n',yaxt='n',xlab='',ylab='',xlim=c(0,100),ylim=c(0,110))
plot(x,y2,col='blue',xlab='x-axis',ylab='y-axis',xlim=c(0,100),ylim=c(0,110))

## xaxt='n' x축을 안보이게 함. 

par(opar)

plot(x,y2,col='blue',xlab='x-axis',ylab='y-axis',xlim=c(0,100),ylim=c(0,110),las=0)
plot(x,y2,col='blue',xlab='x-axis',ylab='y-axis',xlim=c(0,100),ylim=c(0,110),las=1)
plot(x,y2,col='blue',xlab='x-axis',ylab='y-axis',xlim=c(0,100),ylim=c(0,110),las=2)
plot(x,y2,col='blue',xlab='x-axis',ylab='y-axis',xlim=c(0,100),ylim=c(0,110),las=3)

## las 옵션은 0,1,2,3 값들에 따라 x좌표, y좌표 눈금들의 가로, 세로 방향을 바꿈 

#(4) RColorBrewer 패키지: 괜찮은 색깔 조합을 모아놓은 팔레트를 제공함 

library(RColorBrewer)

display.brewer.all() ## 선택가능한 팔레트 목록을 보여줌 

pal <- brewer.pal(5,"Set3") ## Set3 팔레트에서 5개의 색깔 추출


#(5) barplot( )
barplot(VADeaths,col=pal)
barplot(VADeaths, col=pal, beside=T)

#(6) hist( ) : 연속형 변수에 대한 도수분포표 
hist(sqrt(islands),breaks=c(2,30,70,100,140)) ## 막대기 하나 하나의 양끝 좌표 지정 

#(7) pie( )
x <- c(20,30,30,20,15,5)
pie.content <- x/sum(x)
names(pie.content) <- c('Java Script','Java','Python','R','SAS','Julia')
pie(pie.content, main='프로그래밍 언어 사용 비율',clockwise=TRUE,)

#(8) mosiacplot()

mosaicplot(~Sex+Age+Survived, data=Titanic, color=TRUE)


## 1-2. 저수준 함수 그래프 

#(1) lines( )

plot(mtcars$mpg,mtcars$qsec)

fit <- lm(mpg ~ qsec, data=mtcars)

lines(mtcars$mpg,fit$coefficients[1]+mtcars$mpg*fit$coefficients[2], col='red')



#(2) abline( )
plot(mtcars$mpg,mtcars$qsec)
abline(fit,col='red',lty='dashed')


#(3) text( )

plot(-1:1,-1:1, type='n',xlab='x-axis',ylab='y-axis')

points(0,0,pch='+',cex=4,lwd=15) ## cex = 포인트 크기 지정 

text(0,0,'topright',col='red',cex=3,font=20,adj=c(-0.2,-0.4))
text(0,0,'topleft',col='blue',cex=3,font=20,adj=c(1.2,-0.4))
text(0,0,'bottomleft',col='green',cex=3,font=20,adj=c(1.0,1.4))
text(0,0,'bottomright',col='black',cex=3,font=20,adj=c(0,1.4))

### 수식 출력 

plot(1:5,1:5,type='n')

text(3,3,expression(hat(beta)==(X^t)*X^{-1}*X^t*y))

