CREATE TABLE `medicinal` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
`code` varchar(20) NOT NULL default '' COMMENT '药品代码',
`name` varchar(50) NOT NULL DEFAULT '' COMMENT '药品名称',
`unit` varchar(10) NOT NULL DEFAULT '' COMMENT '单位',
`unit_price` float NOT NULL default 0 COMMENT '单价',
`reserve` int not null default 0 COMMENT '库存',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`is_delete` int(20) DEFAULT 0 COMMENT '0:未删除 1:已删除',
PRIMARY KEY (`id`),
INDEX name_index(name)
) ENGINE=InnoDB AUTO_INCREMENT=10000000 DEFAULT CHARSET=utf8mb4 COMMENT '药品表';

CREATE TABLE `medicinal_buy_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
`medicinal_code` varchar(20) NOT NULL default '' COMMENT '药品代码',
`medicinal_name` varchar(50) NOT NULL DEFAULT '' COMMENT '药品名称',
`unit_price` float NOT NULL default 0 COMMENT '单价',
`count` int not null default 0 COMMENT '数量',
`total_price` float NOT NULL default 0 COMMENT '总价',
`buyer_name` varchar(20)  NOT NULL default '' COMMENT '购药人姓名',
`buyer_number` int NOT NULL default 0 COMMENT '购药人工号',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`is_delete` int(20) DEFAULT 0 COMMENT '0:未删除 1:已删除',
PRIMARY KEY (`id`),
INDEX medicinal_code_index(medicinal_code),
INDEX medicinal_name_index(medicinal_name),
INDEX buyer_name_index(buyer_name),
INDEX buyer_number_index(buyer_number)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '药品购买记录表';

CREATE TABLE `medicinal_reserve_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
`medicinal_code` varchar(20) NOT NULL default '' COMMENT '药品代码',
`medicinal_name` varchar(50) NOT NULL DEFAULT '' COMMENT '药品名称',
`unit_price` float NOT NULL default 0 COMMENT '单价',
`count` int not null default 0 COMMENT '数量',
`total_price` float NOT NULL default 0 COMMENT '总价',
`reserve_type` tinyint default 0 comment '库存类型',
`current_reserve` bigint default 0 comment '当前剩余库存' ,
`current_total_price` bigint default 0 comment '当前剩余库存总结',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`is_delete` int(20) DEFAULT 0 COMMENT '0:未删除 1:已删除',
PRIMARY KEY (`id`),
INDEX medicinal_code_index(medicinal_code),
INDEX medicinal_name_index(medicinal_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '药品库存记录表';
