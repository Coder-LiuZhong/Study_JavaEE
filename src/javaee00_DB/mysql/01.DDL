DDL：	数据定义语言		create、drop、alter、show     	数据库、表
DML:	数据操作语言		insert、delete、update			记录
DQL:	数据查询语言		select...from子句...where子句	查询语句
DCL：	数据控制语言		grant							定义访问权限，取消访问权限，安全设置；		
---------------------------------------------------------------------------------------------------------------------
数据库的CRUD操作
	mysql -uroot -proot        --登录数据库服务器(后面没分号哦)
	
	create database day06;                                       --创建数据库；通常一个项目/应用建一个数据库
	create database day06 character set utf8;                    --创建数据库的时候，指定字符集（默认就可以了）；
	create database day06 character set utf8 collate utf8_bin;   --创建数据库的时候，指定字符集，并指定校对规则（默认就可以了）；(有空再研究这玩意)
	
	drop database day06;                                         --删除数据库
	alter database day06 character set gbk;                      --修改数据库（字符集）(是utf8不是utf-8)
	
	show create database day06;               --查看数据库的创建（过程，显示create数据库的语句）
	show databases;                           --查看所有的数据库
	    informartion_schema                   --这三个库不能动，mysql自带的，存放了用户名和密码什么的；
	    performance_schema
	    mysql       
	
	use day06;               -- 切换数据库
	select databse();        -- 查看当前正在使用的数据库
---------------------------------------------------------------------------------------------------------------------
表结构操作
	create table student(
	    sid   int primary key,  --主键；    
	    sname varchar(31),      --逗号； char(固定长度，指定的是字符个数) varchar(可变，省空间，长度最大65535) 存31个汉字和31个字母一样的，不存在汉字要占两个的情况
	    sex   int(2),           --默认2位，超过了也是可以的；
	    age   int,
	    birthday   date         --date(YYYY-MM-DD)/time(hh:mm:ss)/datatime(YYYY-MM-DD hh:mm:ss 默认null)/timestamp(YYYY-MM-DD hh:mm:ss 默认是当前时间，用的多);
	); -- 分号					--只存年份可以用int
	
	其实就是五种常用的:  int、varchar(30)、decimal(6,2)、boolean、data
	六种定义顺序：		`id`  INT(11)  NOT NULL/DEFAULT '0'  AUTO_INCREMENT  PRIMARY KEY  COMMENT '主键'		
						primary key(`id`) 						或者主键放到最下定义
						foreign key(uno) references user(uid) 	外键
	
	列的类型：
	    java：  int、char/string、  double/float、              boolean、data
	    sql:   int、char/varchar、decimal/double/float、boolean、date/time/datetime/timestamp
			   text(长度超过65535用它，存放文本，小说都行)/blob(二进制)
	    
	    decimal(6,2):             标准数据类型，以字符串形式保存数值，欧浦项目中一般用这个，精度高；  
	    						  6是数字的长度，包括小数点，2是小数点后两位
	    double(6,2)/float(6,2):   非标准类型，DB中保存的是近似值，精度低，唯一好处是占用的空间比较小；
	
	列的约束
	    主键约束：  primary key        默认不能为null,必须是唯一的；     外键一般都是指向另外一张表的主键；    一张表只能有一个
	    唯一约束：  unique             可以为null，必须唯一；           唯一约束不可以作为其它表的外键；
	    飞空约束：  not null
	    自动增长：  auto_increment     主键后面接上，插入的时候这字段就可以不用管,或者直接给null；

	
	drop table heima;      -- 删除表。表结构也删除了；delete是一条条删，表结构还在；
	drop table if exists heima;
	    
	alter table student add chengji int not null first;   -- 修改表；add增加一个成绩列；  first 是把这个字段放到第一列，也可以指定放到某个字段后面，after id 
	alter table product add foreign key(cno) references category(cid);      -- 外键
	alter table student drop chengji;                     -- 修改表；drop删除列；
	alter table student change sex gender varchar(2);     -- 修改表；change修改列的名字；
	alter table student modify sex varchar(2);            -- 修改表；modify修改列的类型；
	alter table heima character set gbk;                  -- 修改表的字符集
	
	show tables;           -- 查看所有的表
	show create table student;     -- 查看表的创建过程
	desc student;          -- 查看表的结构
	
	rename table student to heima;         -- 修改表名
---------------------------------------------------------------------------------------------------------------------
