DDL��	���ݶ�������		create��drop��alter��show     	���ݿ⡢��
DML:	���ݲ�������		insert��delete��update			��¼
DQL:	���ݲ�ѯ����		select...from�Ӿ�...where�Ӿ�	��ѯ���
DCL��	���ݿ�������		grant							�������Ȩ�ޣ�ȡ������Ȩ�ޣ���ȫ���ã�		
---------------------------------------------------------------------------------------------------------------------
���ݿ��CRUD����
	mysql -uroot -proot        --��¼���ݿ������(����û�ֺ�Ŷ)
	
	create database day06;                                       --�������ݿ⣻ͨ��һ����Ŀ/Ӧ�ý�һ�����ݿ�
	create database day06 character set utf8;                    --�������ݿ��ʱ��ָ���ַ�����Ĭ�ϾͿ����ˣ���
	create database day06 character set utf8 collate utf8_bin;   --�������ݿ��ʱ��ָ���ַ�������ָ��У�Թ���Ĭ�ϾͿ����ˣ���(�п����о�������)
	
	drop database day06;                                         --ɾ�����ݿ�
	alter database day06 character set gbk;                      --�޸����ݿ⣨�ַ�����(��utf8����utf-8)
	
	show create database day06;               --�鿴���ݿ�Ĵ��������̣���ʾcreate���ݿ����䣩
	show databases;                           --�鿴���е����ݿ�
	    informartion_schema                   --�������ⲻ�ܶ���mysql�Դ��ģ�������û���������ʲô�ģ�
	    performance_schema
	    mysql       
	
	use day06;               -- �л����ݿ�
	select databse();        -- �鿴��ǰ����ʹ�õ����ݿ�
---------------------------------------------------------------------------------------------------------------------
���ṹ����
	create table student(
	    sid   int primary key,  --������    
	    sname varchar(31),      --���ţ� char(�̶����ȣ�ָ�������ַ�����) varchar(�ɱ䣬ʡ�ռ䣬�������65535) ��31�����ֺ�31����ĸһ���ģ������ں���Ҫռ���������
	    sex   int(2),           --Ĭ��2λ��������Ҳ�ǿ��Եģ�
	    age   int,
	    birthday   date         --date(YYYY-MM-DD)/time(hh:mm:ss)/datatime(YYYY-MM-DD hh:mm:ss Ĭ��null)/timestamp(YYYY-MM-DD hh:mm:ss Ĭ���ǵ�ǰʱ�䣬�õĶ�);
	); -- �ֺ�					--ֻ����ݿ�����int
	
	��ʵ�������ֳ��õ�:  int��varchar(30)��decimal(6,2)��boolean��data
	���ֶ���˳��		`id`  INT(11)  NOT NULL/DEFAULT '0'  AUTO_INCREMENT  PRIMARY KEY  COMMENT '����'		
						primary key(`id`) 						���������ŵ����¶���
						foreign key(uno) references user(uid) 	���
	
	�е����ͣ�
	    java��  int��char/string��  double/float��              boolean��data
	    sql:   int��char/varchar��decimal/double/float��boolean��date/time/datetime/timestamp
			   text(���ȳ���65535����������ı���С˵����)/blob(������)
	    
	    decimal(6,2):             ��׼�������ͣ����ַ�����ʽ������ֵ��ŷ����Ŀ��һ������������ȸߣ�  
	    						  6�����ֵĳ��ȣ�����С���㣬2��С�������λ
	    double(6,2)/float(6,2):   �Ǳ�׼���ͣ�DB�б�����ǽ���ֵ�����ȵͣ�Ψһ�ô���ռ�õĿռ�Ƚ�С��
	
	�е�Լ��
	    ����Լ����  primary key        Ĭ�ϲ���Ϊnull,������Ψһ�ģ�     ���һ�㶼��ָ������һ�ű���������    һ�ű�ֻ����һ��
	    ΨһԼ����  unique             ����Ϊnull������Ψһ��           ΨһԼ����������Ϊ�������������
	    �ɿ�Լ����  not null
	    �Զ�������  auto_increment     ����������ϣ������ʱ�����ֶξͿ��Բ��ù�,����ֱ�Ӹ�null��

	
	drop table heima;      -- ɾ���������ṹҲɾ���ˣ�delete��һ����ɾ�����ṹ���ڣ�
	drop table if exists heima;
	    
	alter table student add chengji int not null first;   -- �޸ı���add����һ���ɼ��У�  first �ǰ�����ֶηŵ���һ�У�Ҳ����ָ���ŵ�ĳ���ֶκ��棬after id 
	alter table product add foreign key(cno) references category(cid);      -- ���
	alter table student drop chengji;                     -- �޸ı���dropɾ���У�
	alter table student change sex gender varchar(2);     -- �޸ı���change�޸��е����֣�
	alter table student modify sex varchar(2);            -- �޸ı���modify�޸��е����ͣ�
	alter table heima character set gbk;                  -- �޸ı����ַ���
	
	show tables;           -- �鿴���еı�
	show create table student;     -- �鿴���Ĵ�������
	desc student;          -- �鿴���Ľṹ
	
	rename table student to heima;         -- �޸ı���
---------------------------------------------------------------------------------------------------------------------