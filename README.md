# Hadoop_ex

서버에 하둡 설치 후 간단한 사용을 해보았다.
그 후 자바(이클립스)에서 메이븐으로 wordcount기능을 하는 jar를 직접 만들어 실행해 보았다.

나중에 보기위해 간단한 필기 내용을 첨부해 둔다.
1. 메이븐 
java 실행
eclipse ->file -> new->maven project

create simple 체크
그룹아이디 의미 없음 아무거다
artifact id HadoopMR

jare 버전 J2SE-1.5를 수정해야한다

2. pom.xml 더블클릭
아래내용 추가

```<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
	</properties>
```
-프로젝트 maven -> update project : 일단 업데이트 해둠

https://mvnrepository.com/

위 사이트에서 아래 두개를 검색하여 붙여넣고 
hadoop-common 검색
Apache Hadoop Common » 3.2.2
hadoop-mapreduce-client
Apache Hadoop MapReduce Core » 3.2.2

- 최종적으로 이렇게 작성되야함

```<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>J</groupId>
  <artifactId>HadoopMR</artifactId>
  <version>0.0.1</version>
  <properties>
	  	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
  </properties>
  <dependencies>
  <!-- https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-common -->
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-common</artifactId>
    <version>3.2.2</version>
</dependency>
  <!-- https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-mapreduce-client-core -->
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-mapreduce-client-core</artifactId>
    <version>3.2.2</version>
</dependency>
  
  </dependencies>
</project>
```
정렬 및 저장
- 커맨드 + a, 후 커맨드+ shitf + f

이후에 업데이트 다시시도

프로젝트에서 run as
clean 이후 install 실행



3. 패키지및 클래스 생성
src/main/java
com.J 하위로
driver/WordCount.java
mapper/WordCountMapper.java
reducer/WordCountReducer.java
생성 파일 만듬


4. jar 파일 찾아서 공유폴더로 이동 후 

5. 우분투에서 실행(필요한 디렉토리는 미리 생성해둠)
bin/yarn jar /media/sf_hadoop/HadoopMR-0.0.1.jar com.J.driver.WordCount wordcount-input wordcount-output
- 새로운 패키지 및 클래스 추가시 clean, install 새로 실행 후 jar 파일을 옮겨둔다
bin/yarn jar /media/sf_hadoop/HadoopMR-0.0.1.jar com.J.driver.DepartureDelayCount air-input air-output


6. 확인(ls 로 위치를 찾아 파일명을 추가로 입력해서 확인할 수 있다)
bin/hdfs dfs -text wordcount-output/part-r-00000
