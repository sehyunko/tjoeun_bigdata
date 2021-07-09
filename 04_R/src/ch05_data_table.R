#### 5장. 데이터 테이블 #### 

library(data.table)

flight <- read.csv("D:\\BigData\\Note\\04_R\\inData\\flights14.csv")

flight <- as.data.table(flight)



# 1. origin이 JFK이고 month가 5월인 모든 행을 resul에 얻는다

result <- flight[origin == 'JFK' & month == 5]


# 2. 처음 두 행을 resul에 얻는다

result <- flight[1:2]

# 3. origin으로 오름차순, dest로 내림차순으로 정렬하여 출력

flight[order(origin,-dest)]

# 4. arr_delay열만 출력

flight[,'arr_delay'] ## 데이터 프레임에서의 방식과 동일 


# 5. year열부터 dep_time열까지 출력

flight[,year:dep_time]

# 6. year열과 dep_time열 출력

flight[,c('year','dep_time')]
flight[,.(년도=year,출발시각=dep_time)]

# 7. arr_delay열과 dep_delay열을 출력하되 열이름을 delay_arr과 delay_dep로 변경

flight[ ,.(delay_arr=arr_delay, delay_dep=dep_delay)]


# 8. 지연시간(arr_delay, dep_delay모두 0미만인 비행이 몇 번인지 출력
#         8-1 지연시간의 합이 0미만인 비행이 몇 번인지 출력

## 8번 
flight[arr_delay==0 & dep_delay ==0]

## 8-1번 
flight[dep_delay + arr_delay<0]



#         9. 6월에 출발 공항이 JFK인 모든 항공편의 도착지연 및 출발지연 시간의 평균을 계산

flight_new <- flight[origin=='JFK', list(mean_arr = mean(arr_delay), mean_dep = mean(dep_delay))]


#         11. JFK 공항의 6월 운항 횟수

flight[origin=='JFK' & month==6, .N]

#         12. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 출력

flight[origin=='JFK' & month==6, .(arr_delay,dep_delay)]


#         13. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 제외한 모든 열 출력

flight[origin=='JFK' & month==6, -c('arr_delay', 'dep_delay')]

flight[origin=='JFK' & month==6, -c(arr_delay, dep_delay)] ## 벡터 형태로 출력

#         14. 출발 공항(origin)별 비행 수 출력 (JFK 81483 LGA 84433 EWR 87400)

flight[,.N,by=origin]

#         15. 항공사코드(carrier)가 AA에 대해 출발공항별 비행횟수 계산

flight[carrier=='AA', .N, by=origin]


#         16. origin, dest별로 비행횟수 출력

flight[ ,.N, by = .(origin, dest)]

#         17. 항공사코드(carrier)가 AA에 대해 origin, dest별로 비행횟수 출력

flight[carrier=='AA',.N,by=.(origin, dest)]


#         18. 항공사 코드가 AA에 대해, origin, dest, 월별 평균arr_delay, 평균 dep_delay 출력

flight[carrier=='AA',list(origin, dest, mean_arr_delay=mean(arr_delay), mean_dep_delay=mean(dep_delay)), by=month]


#         19. dep_delay>0가 참이거나 거짓, arr_delay>0가 참이거나 거짓인 각각의 비행횟수

flight[ ,.N, by=.(dep_delay>0)]
flight[ ,.N, by=.(arr_delay<0)]



#         20. Origin==“JFK”에 대해 월별 최대 출발 지연 시간 출력(month로 정렬)

flight[origin=='JFK',.(max_dep_delay = max(dep_delay)),by=month]
