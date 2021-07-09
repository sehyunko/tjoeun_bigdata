library(ggplot2)
library(datasets)
library(gapminder)
library(RColorBrewer)

## 11번 
library(ggplot2)
library(datasets)

ggplot(cars, aes(x=speed, y=dist))+
  geom_point()+
  coord_cartesian(xlim=c(5,20), ylim=c(0,100))+
  geom_smooth(method=lm)+
  labs(title='연습문제1' ,subtitle='제동거리의 산점와 적합도')

## 12번
library(ggplot2)
library(gapminder)
library(RColorBrewer)

ggplot(gapminder, aes(x=gdpPercap, y=lifeExp))+
  geom_point(aes(color=continent))+
  scale_color_manual(values=brewer.pal(5,"Set3"))+
  labs(title='연습문제2',subtitle='1인 국민소득에 대한 기대수명 (대륙별)')

##13번
library(ggplot2)
library(gapminder)
library(RColorBrewer)

ggplot(gapminder, aes(x=continent))+
  geom_bar(aes(fill=continent))+
  scale_color_manual(values=brewer.pal(4,"Set3"))+
  labs(title='연습문제3',subtitle='기대수명이 70을 초과하는 데이터 빈도(대륙별)')

##14번 
library(ggplot2)
library(gapminder)
library(RColorBrewer)
library(dplyr)

over70 <- gapminder %>% 
  filter(lifeExp > 70)

ggplot(over70, aes(x=continent))+
  geom_bar(aes(fill=continent))+
  scale_color_manual(values=brewer.pal(4,"Set3"))+
  labs(title='연습문제4.',subtitle='기대수명이 70을 초과하는 대륙별 나라 빈도')


##15번 
library(ggplot2)
library(gapminder)
library(RColorBrewer)

ggplot(gapminder, aes(x=continent,y=lifeExp))+
  geom_boxplot(aes(fill=continent))+
  scale_color_manual(values=brewer.pal(5,"Set3"))+
  labs(title='연습문제5',subtitle='대륙별 기대수명')


##16번 
library(ggplot2)
library(gapminder)
library(RColorBrewer)

ggplot(gapminder, aes(x=gdpPercap, y=lifeExp, color=continent))+
  geom_point()+
  scale_color_manual(values=brewer.pal(5,"Set3"))+
  scale_x_log10()+
  theme(axis.text.x=element_text(angle=45, hjust = 0.8))+
  facet_wrap(gapminder$year~.)+
  labs(title='연습문제6', subtitle='GDP와 기대수명간의 관계')

## 17번
library(ggplot2)
library(gapminder)

korea_dat <- gapminder %>% 
  filter(country=='Korea, Rep.' | country=='Korea, Dem. Rep.')

ggplot(korea_dat, aes(x=year, y=gdpPercap, color=country, pch=country))+
  geom_point()+
  theme(legend.position = c(0.2,0.8))+
  labs(title='연습문제7', subtitle='GDP 변화 (한국과 북한')

## 18번 
library(ggplot2)
library(gapminder)
library(dplyr)

asia3 <- gapminder %>% 
  filter(country %in% c('China','Japan','Korea, Rep.','Korea, Dem. Rep.'))

ggplot(asia3, aes(x=year, y=gdpPercap, col=country))+
  geom_point()+
  geom_line()+
  labs(title='연습문제8', subtitle='한중일 4개국의 GDP변화 산점도와 추세선')


## 19번

library(ggplot2)
library(gapminder)
library(dplyr)

asia3 <- gapminder %>% 
  filter(country %in% c('China','Japan','Korea, Rep.','Korea, Dem. Rep.'))

ggplot(asia3, aes(x=year, y=pop, col=country))+
  geom_point()+
  geom_line()+
  labs(title='연습문제8', subtitle='한중일 4개국의 인구수 변화 산점도와 추세선')

## 20번 
library(ggplot2)

ggplot(economics, aes(x=date, y=psavert))+
  geom_line(col='red',lwd=0.6)+
  geom_smooth(col='pink')+
  labs(title='연습문제10', subtitle='개인저축률 시계열 그래프')
