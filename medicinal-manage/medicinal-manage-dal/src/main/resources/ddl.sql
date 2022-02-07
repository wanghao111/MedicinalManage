CREATE TABLE `medicinal` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '����id',
`code` varchar(20) NOT NULL default '' COMMENT 'ҩƷ����',
`name` varchar(50) NOT NULL DEFAULT '' COMMENT 'ҩƷ����',
`unit` varchar(10) NOT NULL DEFAULT '' COMMENT '��λ',
`unit_price` float NOT NULL default 0 COMMENT '����',
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
`unit_price` float NOT NULL default 0 COMMENT '����',
`count` int not null default 0 COMMENT '����',
`total_price` float NOT NULL default 0 COMMENT '�ܼ�',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'ҩƷ�����¼��';

CREATE TABLE `medicinal_reserve_record` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '����id',
`medicinal_code` varchar(20) NOT NULL default '' COMMENT 'ҩƷ����',
`medicinal_name` varchar(50) NOT NULL DEFAULT '' COMMENT 'ҩƷ����',
`unit_price` float NOT NULL default 0 COMMENT '����',
`count` int not null default 0 COMMENT '����',
`total_price` float NOT NULL default 0 COMMENT '�ܼ�',
`reserve_type` tinyint default 0 comment '�������',
`current_reserve` bigint default 0 comment '��ǰʣ����' ,
`current_total_price` bigint default 0 comment '��ǰʣ�����ܽ�',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`is_delete` int(20) DEFAULT 0 COMMENT '0:δɾ�� 1:��ɾ��',
PRIMARY KEY (`id`),
INDEX medicinal_code_index(medicinal_code),
INDEX medicinal_name_index(medicinal_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'ҩƷ����¼��';
