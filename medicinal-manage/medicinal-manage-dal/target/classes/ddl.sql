CREATE TABLE `medicinal` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
`code` varchar(20) NOT NULL default '' COMMENT '药品代码',
`name` varchar(50) NOT NULL DEFAULT '' COMMENT '药品名称',
`unit` varchar(10) NOT NULL DEFAULT '' COMMENT '单位',
`unit_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '单价',
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
`unit_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '单价',
`count` int not null default 0 COMMENT '数量',
`total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '总价',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`is_delete` int(20) DEFAULT 0 COMMENT '0:未删除 1:已删除',
PRIMARY KEY (`id`),
INDEX medicinal_code_index(medicinal_code),
INDEX medicinal_name_index(medicinal_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '药品购买记录表';


CREATE TABLE `medicinal_sell_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
`medicinal_code` varchar(20) NOT NULL default '' COMMENT '药品代码',
`medicinal_name` varchar(50) NOT NULL DEFAULT '' COMMENT '药品名称',
`unit_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '单价',
`count` int not null default 0 COMMENT '数量',
`total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '总价',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '药品售卖记录表';

CREATE TABLE `jz_month_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
`from_month` varchar(20) NOT NULL default ''  COMMENT '结转起始月份',
`to_month` varchar(20) NOT NULL default ''  COMMENT '结转目标月份',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '药品结转月份表';

CREATE TABLE `medicinal_jz_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
`medicinal_code` varchar(20) NOT NULL default '' COMMENT '药品代码',
`medicinal_name` varchar(50) NOT NULL DEFAULT '' COMMENT '药品名称',
`unit_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '单价',
`count` int not null default 0 COMMENT '数量',
`total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '总价',
`from_month` varchar(20) NOT NULL default '' COMMENT '结转起始月份',
`to_month` varchar(20) NOT NULL default '' COMMENT '结转目标月份',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
INDEX medicinal_code_index(medicinal_code),
INDEX medicinal_name_index(medicinal_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '药品结转记录表';

CREATE TABLE `medicinal_summary_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
`medicinal_code` varchar(20) NOT NULL default '' COMMENT '药品代码',
`medicinal_name` varchar(50) NOT NULL DEFAULT '' COMMENT '药品名称',
`unit_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '单价',
`buy_count` INT NOT NULL default 0 COMMENT '购入数量',
`buy_total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '购入总价',
`sell_count` INT NOT NULL default 0 COMMENT '售出数量',
`sell_total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '售出总价',
`pre_jz_count` INT NOT NULL default 0 COMMENT '上月结转数量',
`pre_jz_total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '上月结转总价',
`current_jc_count` INT NOT NULL default 0 COMMENT '本月结存数量',
`current_jc_total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '本月结存总价',
`month_info` varchar(50) NOT NULL DEFAULT '' COMMENT '当前月份',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
INDEX medicinal_code_index(medicinal_code,month_info)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '药品库存记录表';





