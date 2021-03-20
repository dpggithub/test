CREATE TABLE `push_message` (
  `id` varchar(20) NOT NULL DEFAULT '' COMMENT '主键id',
  `msg` varchar(1024) NOT NULL DEFAULT '' COMMENT '消息',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `update_time` bigint(13) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;