CREATE TABLE `medicinal` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '����id',
`code` varchar(20) NOT NULL default '' COMMENT 'ҩƷ����',
`name` varchar(50) NOT NULL DEFAULT '' COMMENT 'ҩƷ����',
`unit` varchar(10) NOT NULL DEFAULT '' COMMENT '��λ',
`unit_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '����',
`reserve` int not null default 0 COMMENT '���',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`is_delete` int(20) DEFAULT 0 COMMENT '0:δɾ�� 1:��ɾ��',
PRIMARY KEY (`id`),
INDEX name_index(name)
) ENGINE=InnoDB AUTO_INCREMENT=10000000 DEFAULT CHARSET=utf8mb4 COMMENT 'ҩƷ��';


CREATE TABLE `medicinal_buy_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '����id',
`medicinal_code` varchar(20) NOT NULL default '' COMMENT 'ҩƷ����',
`medicinal_name` varchar(50) NOT NULL DEFAULT '' COMMENT 'ҩƷ����',
`unit_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '����',
`count` int not null default 0 COMMENT '����',
`total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '�ܼ�',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`is_delete` int(20) DEFAULT 0 COMMENT '0:δɾ�� 1:��ɾ��',
PRIMARY KEY (`id`),
INDEX medicinal_code_index(medicinal_code),
INDEX medicinal_name_index(medicinal_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'ҩƷ�����¼��';


CREATE TABLE `medicinal_sell_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '����id',
`medicinal_code` varchar(20) NOT NULL default '' COMMENT 'ҩƷ����',
`medicinal_name` varchar(50) NOT NULL DEFAULT '' COMMENT 'ҩƷ����',
`unit_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '����',
`count` int not null default 0 COMMENT '����',
`total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '�ܼ�',
`buyer_name` varchar(20)  NOT NULL default '' COMMENT '��ҩ������',
`buyer_number` int NOT NULL default 0 COMMENT '��ҩ�˹���',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`is_delete` int(20) DEFAULT 0 COMMENT '0:δɾ�� 1:��ɾ��',
PRIMARY KEY (`id`),
INDEX medicinal_code_index(medicinal_code),
INDEX medicinal_name_index(medicinal_name),
INDEX buyer_name_index(buyer_name),
INDEX buyer_number_index(buyer_number)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'ҩƷ������¼��';

CREATE TABLE `jz_month_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '����id',
`from_month` varchar(20) NOT NULL default ''  COMMENT '��ת��ʼ�·�',
`to_month` varchar(20) NOT NULL default ''  COMMENT '��תĿ���·�',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'ҩƷ��ת�·ݱ�';

CREATE TABLE `medicinal_jz_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '����id',
`medicinal_code` varchar(20) NOT NULL default '' COMMENT 'ҩƷ����',
`medicinal_name` varchar(50) NOT NULL DEFAULT '' COMMENT 'ҩƷ����',
`unit_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '����',
`count` int not null default 0 COMMENT '����',
`total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '�ܼ�',
`from_month` varchar(20) NOT NULL default '' COMMENT '��ת��ʼ�·�',
`to_month` varchar(20) NOT NULL default '' COMMENT '��תĿ���·�',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
INDEX medicinal_code_index(medicinal_code),
INDEX medicinal_name_index(medicinal_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'ҩƷ��ת��¼��';

CREATE TABLE `medicinal_summary_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '����id',
`medicinal_code` varchar(20) NOT NULL default '' COMMENT 'ҩƷ����',
`medicinal_name` varchar(50) NOT NULL DEFAULT '' COMMENT 'ҩƷ����',
`unit_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '����',
`buy_count` INT NOT NULL default 0 COMMENT '��������',
`buy_total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '�����ܼ�',
`sell_count` INT NOT NULL default 0 COMMENT '�۳�����',
`sell_total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '�۳��ܼ�',
`pre_jz_count` INT NOT NULL default 0 COMMENT '���½�ת����',
`pre_jz_total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '���½�ת�ܼ�',
`current_jc_count` INT NOT NULL default 0 COMMENT '���½������',
`current_jc_total_price` DECIMAL(18,2) NOT NULL default 0 COMMENT '���½���ܼ�',
`month_info` varchar(50) NOT NULL DEFAULT '' COMMENT '��ǰ�·�',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
INDEX medicinal_code_index(medicinal_code,month_info)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'ҩƷ����¼��';





