## 4장. 데이터 베이스와 연동하기 ## 

## Oracle DB와 연동 

library(RJDBC)
library(sqldf)

sqldf("select * from iris order by `Sepal.Length`") ## 쿼리문 내에 홑따옴표를 넣어야 하는 경우, 키보드 ~ 아래의 ``를 이용한다. 

# 1. 드라이버 클래스 로드 

drv <- JDBC("oracle.jdbc.driver.OracleDriver", classPath='ojdbc6.jar')

# 2. 데이터 베이스 연결 

conn <- dbConnect(drv,"jdbc:oracle:thin:@localhost","scott","tiger")

# 3. SQL문 전송, 결과 받기 

rs <- dbSendQuery(conn, 'select * from emp where deptno = 40')
emp <- fetch(rs,-1) ## -1은 모든 행을 불러올 것을 의미. fetch() 함수로 DB내의 데이터 테이블을 data frame의 형태로 가져온다 
head(emp)

# SQL문 전송 + 결과 받기를 한번에 하는 법

emp <- dbGetQuery(conn, "select * from emp")
head(emp)

# DB 데이터 수정 SQL 전송 (update, insert, delete)
dbSendUpdate(conn,'insert into DEPT values (50, `it`,`Seoul`)')
dbSendUpdate(conn, "update DEPT set loc='Pusan'")

# 데이터 연결해제 
dbDisconnect(conn)

# 드라이버 언로드 : DB연결 해제시 자동으로 해제됨 -> dbUnloadDriver 반환값이 FALSE 가 나옴 
dbUnloadDriver(drv)


## MySQL 과 연동하기 

# 사전작업: 
# ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'mysql'; 이거를 mysql에서 실시함
# RJDBC 패키지 언로드 : RJDBC와 RMySQL이 서로 충돌하는 경우가 발생할 수 있으므로 미리 언로드한다. 
detach("package:RJDBC",unload=TRUE)


library(RMySQL)

#1. 드라이버 로드
drv <- dbDriver("MySQL")

#2. DB와 연결한다
conn <- dbConnect(conn, host=localhost, dbname="kimdb", user="root", password="mysql")

#3. SQL 전송 + 결과받기 
rs <- dbSendQuery(conn, "select * from personal")

fetch(rs, -1)

## SQL문 전송과 결과받기를 한번에 하기 
emp <- dbGetQuery(conn, "select * from emp")
head(emp)

## DB의 테이블을 한꺼번에 조회하기 
emp <- dbReadTable(conn, "personal")

# 4. 드라이버와 커넥션 언로드하기 
dbDisconnect(conn)
dbDisconnect(drv) # 이미 커넥션이 언로드 되며 드라이버 까지 언로드 된 상황이라 오류 발생. 
