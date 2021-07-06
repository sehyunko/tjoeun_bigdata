
# [문제2] 10 에서 38사이의 숫자 중에서 2씩 증가한 값으로 벡터를 생성하고
# 3행 5열의 매트릭스를 만들어 m1 에 저장한다(행 우선 저장).

v1 <- seq(10,38,2)
(m1 <- matrix(v1,nrow=3,byrow=TRUE))


# [문제3] seq() 또는 rep() 함수를 이용하여 다음 결과가 나오도록 명령을 작성한다.
# (1) 1, 3, 5, 7, 9
# (2) 1, 1, 1, 1, 1
# (3) 1, 2, 3, 1, 2, 3, 1, 2, 3
# (4) 1, 1, 2, 2, 3, 3, 4, 4
(seq(1,9,2))
(rep(1,5))
(rep(c(1,2,3),3))
(rep(1:4,each=2))


# [문제4] 1부터 10 까지 출력하는데 3씩 증가 되는 형태로(1 4 7 10)저장되는 벡터를 정의하여 v3 변수에 저장한다.(또한 각각 값마다 "A", "B", "C", D" 라는 이름을 부여한다.)

v <- seq(1,10,3)
names(v) <- c('A','B','C','D')
v



# [문제5] 1부터 100으로 구성되는 7개의 중복되지 않는 데이터를 추출하여 count 라는 백터를 만든다. 
#       week.korname 이라는 이름으로 “일요일”, “월요일”,”화요일”,…,”토요일” 값으로 벡터를 만든다. 
#       다음 형식으로 구성되는 벡터를 생성하여 출력한다.
#       추출된 값이 – 21, 40, 11, 55, 70, 90, 30 이라면 다음과 같이 출력한다.
# 		일요일 : 21   월요일 : 40   화요일 : 11 ……………..   토요일 : 30
#       값이 가장 큰 요일의 명칭을 출력한다.
#       값이 가장 작은 요일의 명칭을 출력한다.
#       50보다 큰 값에 해당하는 요일의 명칭을 출력한다.

count <- sample(1:100,7, replace = FALSE)
week.korname <- c('월','화','수','목','금','토','일')
names(count) <- week.korname 

count[which(count==max(count))]
count[which(count==min(count))]
count[which(count > 50)]


# [문제6]  다음과 같이 값이 구성되는 매트릭스를 정의하여 m1 에 저장한다.
#        1,2,3 의 벡터 n1, 4,5,6 의 벡터 n2, 7,8,9 의 벡터 n3 를 이용하여 matrix를 생성한다.
n1 <- 1:3
n2 <- 4:6
n3 <- 7:9 

(m1 <- cbind(n1,n2,n3))
 
# [문제7] 다음과 같이 값이 구성되는 매트릭스를 정의하여 m2 에 저장한다.
#        1~9 의 벡터를 이용하여 matrix를 생성하고 출력한다.
(m2 <- matrix(1:9, nrow=3))




# [문제9] 다음과 같이 구성 되는 2행 3열 매트릭스 alpha를 생성한 후에
#         
# 
#        alpha에 ‘x’, ‘y’, ‘z’ 라는 행을 추가하여 alpha2 를 만들고 출력한다.
#        alpha에 ‘s’, ‘p’ 라는 열을 추가하여 alpha3 를 만들고 출력한다.

alpha <- matrix(nrow=3,ncol=2)
rownames(alpha) <- c('x','y','z')
colnames(alpha) <- c('s','p')
alpha 



# [문제13] c() 함수로 먼저 벡터를 생성한 다음 data.frame()사용해서 다음과 같이 구성되는 데이터 프레임 df3를 만들어 출력해 본다.(제품명이 팩터형이 되지 않게 한다.)
# 	제품명	가격	판매량
# 	사과	1800	24
# 	딸기	1500	38
# 	수박	3000	13

product <-c('사과','딸기','수박')
price <- c(1800,1500,3000)
sales <- c(24,38,13)

df3 <- data.frame(list(제품명=c('사과','딸기','수박'), 가격=c(1800,1500,3000), 판매량=c(24,38,13)))
df3


# [문제15] 다음 세 벡터를 이용하여 데이터프레임 df4를 생성하고, name 변수는 문자, gender 변수는 팩터, math 변수는 숫자 데이터의 유형이라는 것을 확인하시오.
 	
  name <- c('Potter', 'Elsa', 'Gates', 'Wendy', 'Ben')
 	gender <- factor(c('M', 'F', 'M', 'F','M'))
 	math <- c(85, 76, 99, 88, 40)
 	
 	df4 <- data.frame(list(name=name, gender=gender, math=math))
 
# 위에서 만든 데이터프레임에 대해 다음 작업을 수행하시오. 
# (a) stat 변수를 추가하시오.
 	stat <- c(76, 73, 95, 82, 35)
 	df4$stat <- stat
 	
# (b) math 변수와 stat 변수의 합을 구하여 score 변수에 저장하시오. 
 	df4$score <- math+stat
 	
# (c) 논리 연산 인덱싱을 이용하여 score가 150 이상이면 A, 100 이상 150 미만이면 B, 100 미만은 C등급을 부여하고 grade 변수에 저장하시오.	
  df4$grade <- 0
 	
  index.a <- which(df4$score >= 150)
 	df4$grade[index.a] <- 'A'
 	
 	index.b <- which(df4$score >= 100 & df4$score <150)
 	df4$grade[index.b] <- 'B'
 	
 	index.c <- which(df4$score < 100)
 	df4$grade[index.c] <- 'C'
 	
 	df4

 
# [문제18] 다음 리스트에서 A를 "Alpha"로 대체한다.
 	 li = list(c(3,5,7), c('A', 'B', 'C'))
   li[[2]][1]<- 'Alpha'
   li	
 	
 	
# [문제19] 다음 리스트에서 첫 번째 원소(alpha)의 각 값에 10을 더하여 출력한다.
 	li = list(alpha=0:4, beta=sqrt(1:5), gamma=log(1:5))
  li$alpha <- li$alpha +10
  li   
   
    
# [문제20] 다음 리스트는 math, writing, reading의 중간고사 및 기말고사 점수이다. 
# 전체 평균을 계산하여 출력한다.
#       (힌트 : unlist() 함수를 활용한다. unlist() : 리스트를 벡터형식의 데이터셋으로 풀어주는 함수)
  score <- list(math=list(95, 90), writing=list(90, 85), reading=list(85, 80))
  
  mean(unlist(score$math))
  mean(unlist(score$writing))
  mean(unlist(score$reading))
  
  
  


# [문제22] iris 데이터를 정렬한다
# Petal.Length를 기준으로 내림차순으로 정렬하세요
# Sepal.Width 를 내림차순 정렬하세요
  
  orderBy(~-Petal.Length,data=iris)
  orderBy(~-Sepal.Width,data=iris)
  
  
# [문제 23] iris 데이터의 종별 데이터 개수 출력한다
  
  table(iris$Species)
  
# [문제 24] 종별 Sepal.Length의 합을 출력한다.
  
  summaryBy(Sepal.Length~Species, data=iris, FUN=sum)
  
  
# [문제 25] Sepal.Length, Sepal.Width, Petal.Length, Petal.Width의 평균을 출력
# apply, lappy, sapply이용
  
  apply(iris[,c('Sepal.Length', 'Sepal.Width', 'Petal.Length', 'Petal.Width')], MARGIN=2,FUN=mean) 
  ## 주의 할 것 : iris$Sepal.Length 이런 식으로 가져오면 벡터 형태로 가져오는게 되어서 apply 함수에서 연산을 못함!! 
  ## 꼭 데이터 프레임 또는 행렬의 형태로 가져올 것 !! 
  
  lapply(iris[,c('Sepal.Length', 'Sepal.Width', 'Petal.Length', 'Petal.Width')], MARGIN=2,FUN=mean)
  
  sapply(iris[,c('Sepal.Length', 'Sepal.Width', 'Petal.Length', 'Petal.Width')], MARGIN=2,FUN=mean) 

# 종별 Sepal.Length의 평균 출력
  
summaryBy(Sepal.Length ~ Species, data=iris, FUN=mean)
  

# [문제 26] 꽃받침의 길이(Sepal.Length)가 가장 긴 꽃의 종은 무엇인가요?

iris[which.max(iris$Sepal.Length==max(iris$Sepal.Length)),]$Species

