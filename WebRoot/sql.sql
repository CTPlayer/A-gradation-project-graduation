create table user(
	id int not null primary key auto_increment,
	username text not null,
	password text not null,
	qq text not null,
	email text not null 
)ENGINE = InnoDB DEFAULT CHARSET=utf8;
insert into user (username,password,qq,email) values ('chengtong',1234,1056205193,'1056205193@qq.com');
create table announcement(
	id int not null primary key auto_increment,
	title text not null,
	content text not null,
	posted_by text not null,
	createtime date,
	updatetime date
)ENGINE = InnoDB DEFAULT CHARSET=utf8;
insert into announcement (title,content,posted_by,createtime,updatetime) values ('填埋气体','项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导出，高于地面排放，对大气环境影响较小。经类比分析，在夏季下风向500m范围之外一般闻不到恶臭气味，对周围村庄不会产生明显的臭气污染影响。据此确定本项目的卫生防护距离为500m。','莫嘉宇','2015-12-20 22-20-18','2015-12-20 22-12-20');
insert into announcement (title,content,posted_by,createtime,updatetime) values ('扬尘及飘飞物','填埋作业时及时压实、覆盖，可以避免扬尘污染；填埋场设防护网及绿化带隔离，飘飞物对周围环项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导境影响不明显。','Wen HuaYu','2015-12-20 22-20-18','2015-12-20 22-20-18');
insert into announcement (title,content,posted_by,createtime,updatetime) values ('运输对环境的影响','生活垃圾及渗滤液转运为公路运输，沿途不经过风景区、水源保护区等敏感点，途径公路距最近村庄黄石坎村约30m。垃圾采用密闭式压缩车运输、项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导渗滤液转运采用密闭式罐车运输。在确保不发生泄漏的情况下对沿线环境影响不大。','孙爱民','2015-12-20 22-20-18','2015-12-20 22-20-18');
insert into announcement (title,content,posted_by,createtime,updatetime) values ('运输对环境的影响','生活垃圾及渗滤液转运为公路运输，沿途不经过风景区、水源保护区等敏感点，途径公路距最近村庄黄石坎村约30m。垃圾采用密闭式压缩车运输、渗滤液转运采用密闭式罐车运输。在确保不项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导发生泄漏的情况下对沿线环境影响不大。','孙爱民','2015-12-21 22-20-18','2015-12-21 22-20-18');
insert into announcement (title,content,posted_by,createtime,updatetime) values ('扬尘及飘飞物','填埋作业时及时压实、覆盖，可以避免扬尘污染；填埋场设防护网及绿化带隔离，飘飞物对周围环项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导境影响不明显。','Wen HuaYu','2015-12-20 22-20-18','2015-12-20 22-20-18');
insert into announcement (title,content,posted_by,createtime,updatetime) values ('扬尘及飘飞物','填埋作业时及时压实、覆盖，可以避免扬尘污染；填埋场设防护网及绿化带隔离，飘飞物对周围环项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导境影响不明显。','Wen HuaYu','2015-12-20 22-20-18','2015-12-20 22-20-18');
insert into announcement (title,content,posted_by,createtime,updatetime) values ('扬尘及飘飞物','填埋作业时及时压实、覆盖，可以避免扬尘污染；填埋场设防护网及绿化带隔离，飘飞物对周围环项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导境影响不明显。','Wen HuaYu','2015-12-20 22-20-18','2015-12-20 22-20-18');
insert into announcement (title,content,posted_by,createtime,updatetime) values ('扬尘及飘飞物','填埋作业时及时压实、覆盖，可以避免扬尘污染；填埋场设防护网及绿化带隔离，飘飞物对周围环项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导项目产生的填埋气体主要成分为甲烷、二氧化碳和H2S、NH3等。填埋气体通过导气石笼导境影响不明显。','Wen HuaYu','2015-12-20 22-20-18','2015-12-20 22-20-18');

create table lessions(
	lid int not null primary key auto_increment,
	subject text not null,
	type text not null,
	property text not null,
	major text not null,
	remark text not null,
	tid int
)ENGINE = InnoDB DEFAULT CHARSET=utf8;
insert into lessions (subject,type,property,major,remark,tid) values ('软件测试','理论课','必修课','软件工程','同学们要好好学啊',1)

create table upload(
	uid int not null primary key auto_increment,
	filename text not null,
	videoname text not null,
	lid int
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

create table teacher(
	tid int not null primary key auto_increment,
	username text not null,
	password text not null,
	qq text not null,
	email text not null,
	institute text not null,
	resource text 
)ENGINE = InnoDB DEFAULT CHARSET=utf8;
select * from teacher where email = '1083122793@qq.com' and password = 'teacher1234';
insert into teacher (username,password,qq,email,institute,resource) values ('张功杰','teacher1234','1083122793','1083122793@qq.com','计算机科学与技术学院','false')
insert into teacher (username,password,qq,email,institute,resource) values ('张杰','teacher1234','9892927','9892927@qq.com','体育学院','false')
insert into teacher (username,password,qq,email,institute,resource) values ('伊相杰','teacher1234','7892927','7892927@qq.com','生命科学学院','false')
insert into teacher (username,password,qq,email,institute,resource) values ('王杰','teacher1234','1189292227','1189292227@qq.com','音乐学院','false')
insert into teacher (username,password,qq,email,institute,resource) values ('周杰','teacher1234','1089231927','1089231927@qq.com','美术学院','false')

insert into teacher (username,password,qq,email,institute,resource) values ('小智','teacher1234','1083123123','1083123123@qq.com','计算机科学与技术学院','true')
insert into teacher (username,password,qq,email,institute,resource) values ('小刚','teacher1234','98921233','98921233@qq.com','体育学院','true')
insert into teacher (username,password,qq,email,institute,resource) values ('小霞','teacher1234','78921231','78921231@qq.com','生命科学学院','true')
insert into teacher (username,password,qq,email,institute,resource) values ('武藏','teacher1234','11891227','11891227@qq.com','音乐学院','true')
insert into teacher (username,password,qq,email,institute,resource) values ('小次郎','teacher1234','1045923197','1045923197@qq.com','美术学院','true')
insert into teacher (username,password,qq,email,institute,resource) values ('喵喵','teacher1234','1045213197','1045213197@qq.com','美术学院','true')

create table paper(
	pid int not null primary key auto_increment,
	papername text not null,
	publication text not null,
	announcetime date not null,
	level text not null,
	author text not null,
	tid int
)ENGINE=InnoDB DEFAULT CHARSET =utf8;
insert into paper (papername,publication,announcetime,level,author,tid) values ('基于模板的关联规则挖掘算法','计算机工程与设计','2015-12-25','中文核心期刊','小智',4)

create table item(
	iid int not null primary key auto_increment,
	itemname text not null,
	itemtime date not null,
	support text not null,
	remark text,
	tid int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into item (itemname,itemtime,support,remark,tid) values ('大学生创业项目','2015-12-25','江苏师范大学','同学们要好好创业啊',4)

create table blog(
	bid int not null primary key auto_increment,
	address text not null,
	tid int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into blog (address,tid) values ('www.baidu.com',1)
insert into blog (address,tid) values ('www.baidu.com',2)
insert into blog (address,tid) values ('www.baidu.com',3)

create table bbs(
	bbsid int not null primary key auto_increment,
	title text not null,
	times timestamp not null,
	txt text not null,
	id int,
	tid int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
select * from bbs;

create table answer(
	aid int not null primary key auto_increment,
	retxt text not null,
	retime timestamp not null,
	bbsid int not null,
	tid int not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table answer modify bbsid int null;
desc answer;
select * from answer;
select * from user;
select * from bbs;