prompt
prompt Creating table SYS_DEPT
prompt =======================
prompt
create table STONE.SYS_DEPT
(
  dept_id     INTEGER not null,
  pid         INTEGER,
  pids        VARCHAR2(512),
  simple_name VARCHAR2(45),
  full_name   VARCHAR2(255),
  description VARCHAR2(255),
  version     NUMBER(11),
  sort        NUMBER(11),
  create_time DATE,
  update_time DATE,
  create_user INTEGER,
  update_user INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table STONE.SYS_DEPT
  add primary key (DEPT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

INSERT INTO sys_dept VALUES (24, 0, '[0],', '总公司', '总公司', '', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO sys_dept VALUES (25, 24, '[0],[24],', '开发部', '开发部', '', NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO sys_dept VALUES (26, 24, '[0],[24],', '运营部', '运营部', '', NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO sys_dept VALUES (27, 24, '[0],[24],', '战略部', '战略部', '', NULL, 4, NULL, NULL, NULL, NULL);


prompt
prompt Creating table SYS_DICT
prompt =======================
prompt
create table STONE.SYS_DICT
(
  dict_id     INTEGER not null,
  pid         INTEGER,
  name        VARCHAR2(255),
  code        VARCHAR2(255),
  description VARCHAR2(255),
  sort        NUMBER(11),
  create_time DATE,
  update_time DATE,
  create_user INTEGER,
  update_user INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table STONE.SYS_DICT
  add primary key (DICT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


INSERT INTO sys_dict VALUES (50, 0, '性别', 'SEX', '', 0, NULL, NULL, NULL, NULL);
INSERT INTO sys_dict VALUES (51, 50, '男', 'M', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO sys_dict VALUES (52, 50, '女', 'F', NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO sys_dict VALUES (53, 0, '状态', 'STATUS', '', 0, NULL, NULL, NULL, NULL);
INSERT INTO sys_dict VALUES (54, 53, '启用', 'ENABLE', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO sys_dict VALUES (55, 53, '禁用', 'DISABLE', NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO sys_dict VALUES (56, 0, '账号状态', 'ACCOUNT_STATUS', '', 0, NULL, NULL, NULL, NULL);
INSERT INTO sys_dict VALUES (57, 56, '启用', 'ENABLE', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO sys_dict VALUES (58, 56, '冻结', 'FREEZE', NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO sys_dict VALUES (59, 56, '已删除', 'DELETED', NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO sys_dict VALUES (60, 0, '是否删除', 'DEL_FLAG', '用于数据库中是否删除的标记', NULL, null, NULL, 1, NULL);
INSERT INTO sys_dict VALUES (61, 60, '已经删除', 'Y', '', NULL, null, NULL, 1, NULL);
INSERT INTO sys_dict VALUES (62, 60, '未删除', 'N', '', NULL, null, NULL, 1, NULL);

prompt
prompt Creating table SYS_FILE_INFO
prompt ============================
prompt
create table STONE.SYS_FILE_INFO
(
  file_id     VARCHAR2(50) not null,
  file_data   BLOB,
  create_time DATE,
  update_time DATE,
  create_user INTEGER,
  update_user INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table STONE.SYS_FILE_INFO
  add primary key (FILE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_LOGIN_LOG
prompt ============================
prompt
create table STONE.SYS_LOGIN_LOG
(
  login_log_id INTEGER not null,
  log_name     VARCHAR2(255),
  user_id      INTEGER,
  create_time  DATE,
  succeed      VARCHAR2(255),
  message      VARCHAR2(4000),
  ip_address   VARCHAR2(255)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
alter table STONE.SYS_LOGIN_LOG
  add primary key (LOGIN_LOG_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table SYS_MENU
prompt =======================
prompt
create table STONE.SYS_MENU
(
  menu_id       INTEGER not null,
  code          VARCHAR2(255),
  pcode         VARCHAR2(255),
  pcodes        VARCHAR2(255),
  name          VARCHAR2(255),
  icon          VARCHAR2(255),
  url           VARCHAR2(255),
  sort          NUMBER(8),
  levels        NUMBER(8),
  menu_flag     VARCHAR2(32),
  description   VARCHAR2(255),
  status        VARCHAR2(32),
  new_page_flag VARCHAR2(32),
  open_flag     VARCHAR2(32),
  create_time   DATE,
  update_time   DATE,
  create_user   INTEGER,
  update_user   INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table STONE.SYS_MENU
  add primary key (MENU_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

INSERT INTO sys_menu VALUES (105, 'system', '0', '[0],', '系统管理', 'layui-icon layui-icon-username', '#', 30, 1, 'Y', NULL, 'ENABLE', NULL, '1', NULL, null, NULL, 1);
INSERT INTO sys_menu VALUES (106, 'mgr', 'system', '[0],[system],', '用户管理', '', '/mgr', 1, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (107, 'mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', NULL, '/mgr/add', 1, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (108, 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', NULL, '/mgr/edit', 2, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (109, 'mgr_delete', 'mgr', '[0],[system],[mgr],', '删除用户', NULL, '/mgr/delete', 3, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (110, 'mgr_reset', 'mgr', '[0],[system],[mgr],', '重置密码', NULL, '/mgr/reset', 4, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (111, 'mgr_freeze', 'mgr', '[0],[system],[mgr],', '冻结用户', NULL, '/mgr/freeze', 5, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (112, 'mgr_unfreeze', 'mgr', '[0],[system],[mgr],', '解除冻结用户', NULL, '/mgr/unfreeze', 6, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (113, 'mgr_setRole', 'mgr', '[0],[system],[mgr],', '分配角色', NULL, '/mgr/setRole', 7, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (114, 'role', 'system', '[0],[system],', '角色管理', NULL, '/role', 2, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (115, 'role_add', 'role', '[0],[system],[role],', '添加角色', NULL, '/role/add', 1, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (116, 'role_edit', 'role', '[0],[system],[role],', '修改角色', NULL, '/role/edit', 2, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (117, 'role_remove', 'role', '[0],[system],[role],', '删除角色', NULL, '/role/remove', 3, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (118, 'role_setAuthority', 'role', '[0],[system],[role],', '配置权限', NULL, '/role/setAuthority', 4, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (119, 'menu', 'system', '[0],[system],', '菜单管理', NULL, '/menu', 4, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (120, 'menu_add', 'menu', '[0],[system],[menu],', '添加菜单', NULL, '/menu/add', 1, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (121, 'menu_edit', 'menu', '[0],[system],[menu],', '修改菜单', NULL, '/menu/edit', 2, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (122, 'menu_remove', 'menu', '[0],[system],[menu],', '删除菜单', NULL, '/menu/remove', 3, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (128, 'log', 'system', '[0],[system],', '业务日志', NULL, '/log', 6, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (130, 'druid', 'system', '[0],[system],', '监控管理', NULL, '/druid', 7, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (131, 'dept', 'system', '[0],[system],', '部门管理', NULL, '/dept', 3, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (132, 'dict', 'system', '[0],[system],', '字典管理', NULL, '/dict', 4, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (133, 'loginLog', 'system', '[0],[system],', '登录日志', NULL, '/loginLog', 6, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (134, 'log_clean', 'log', '[0],[system],[log],', '清空日志', NULL, '/log/delLog', 3, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (135, 'dept_add', 'dept', '[0],[system],[dept],', '添加部门', NULL, '/dept/add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (136, 'dept_update', 'dept', '[0],[system],[dept],', '修改部门', NULL, '/dept/update', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (137, 'dept_delete', 'dept', '[0],[system],[dept],', '删除部门', NULL, '/dept/delete', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (138, 'dict_add', 'dict', '[0],[system],[dict],', '添加字典', NULL, '/dict/add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (139, 'dict_update', 'dict', '[0],[system],[dict],', '修改字典', NULL, '/dict/update', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (140, 'dict_delete', 'dict', '[0],[system],[dict],', '删除字典', NULL, '/dict/delete', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (141, 'notice', 'system', '[0],[system],', '通知管理', NULL, '/notice', 9, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (142, 'notice_add', 'notice', '[0],[system],[notice],', '添加通知', NULL, '/notice/add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (143, 'notice_update', 'notice', '[0],[system],[notice],', '修改通知', NULL, '/notice/update', 2, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (144, 'notice_delete', 'notice', '[0],[system],[notice],', '删除通知', NULL, '/notice/delete', 3, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (145, 'hello', 'system_message', '[0],[system_message],', '系统消息', 'layui-icon layui-icon-tips', '/notice/hello', 1, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, null, NULL, 1);
INSERT INTO sys_menu VALUES (149, 'api_mgr', 'dev_tools', '[0],[dev_tools],', '接口文档', 'fa-leaf', '/swagger-ui.html', 2, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (150, 'to_menu_edit', 'menu', '[0],[system],[menu],', '菜单编辑跳转', '', '/menu/menu_edit', 4, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (151, 'menu_list', 'menu', '[0],[system],[menu],', '菜单列表', '', '/menu/list', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (152, 'to_dept_update', 'dept', '[0],[system],[dept],', '修改部门跳转', '', '/dept/dept_update', 4, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (153, 'dept_list', 'dept', '[0],[system],[dept],', '部门列表', '', '/dept/list', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (154, 'dept_detail', 'dept', '[0],[system],[dept],', '部门详情', '', '/dept/detail', 6, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (155, 'to_dict_edit', 'dict', '[0],[system],[dict],', '修改菜单跳转', '', '/dict/dict_edit', 4, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (156, 'dict_list', 'dict', '[0],[system],[dict],', '字典列表', '', '/dict/list', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (157, 'dict_detail', 'dict', '[0],[system],[dict],', '字典详情', '', '/dict/detail', 6, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (158, 'log_list', 'log', '[0],[system],[log],', '日志列表', '', '/log/list', 2, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (159, 'log_detail', 'log', '[0],[system],[log],', '日志详情', '', '/log/detail', 3, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (160, 'del_login_log', 'loginLog', '[0],[system],[loginLog],', '清空登录日志', '', '/loginLog/delLoginLog', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (161, 'login_log_list', 'loginLog', '[0],[system],[loginLog],', '登录日志列表', '', '/loginLog/list', 2, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (162, 'to_role_edit', 'role', '[0],[system],[role],', '修改角色跳转', '', '/role/role_edit', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (163, 'to_role_assign', 'role', '[0],[system],[role],', '角色分配跳转', '', '/role/role_assign', 6, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (164, 'role_list', 'role', '[0],[system],[role],', '角色列表', '', '/role/list', 7, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (165, 'to_assign_role', 'mgr', '[0],[system],[mgr],', '分配角色跳转', '', '/mgr/role_assign', 8, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (166, 'to_user_edit', 'mgr', '[0],[system],[mgr],', '编辑用户跳转', '', '/mgr/user_edit', 9, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (167, 'mgr_list', 'mgr', '[0],[system],[mgr],', '用户列表', '', '/mgr/list', 10, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO sys_menu VALUES (171, 'dev_tools', '0', '[0],', '开发工具', 'layui-icon layui-icon-app', '#', 20, 1, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, null, NULL, 1);
INSERT INTO sys_menu VALUES (172, 'system_message', '0', '[0],', '系统消息', 'layui-icon layui-icon-tips', '#', 10, 1, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, null, NULL, 1);


prompt
prompt Creating table SYS_NOTICE
prompt =========================
prompt
create table STONE.SYS_NOTICE
(
  notice_id   INTEGER not null,
  title       VARCHAR2(255),
  content     VARCHAR2(4000),
  create_time DATE,
  create_user INTEGER,
  update_time DATE,
  update_user INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table STONE.SYS_NOTICE
  add primary key (NOTICE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_OPERATION_LOG
prompt ================================
prompt
create table STONE.SYS_OPERATION_LOG
(
  operation_log_id INTEGER not null,
  log_type         VARCHAR2(32),
  log_name         VARCHAR2(255),
  user_id          INTEGER,
  class_name       VARCHAR2(255),
  method           VARCHAR2(4000),
  create_time      DATE,
  succeed          VARCHAR2(32),
  message          VARCHAR2(4000)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
alter table STONE.SYS_OPERATION_LOG
  add primary key (OPERATION_LOG_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table SYS_RELATION
prompt ===========================
prompt
create table STONE.SYS_RELATION
(
  relation_id INTEGER not null,
  menu_id     INTEGER,
  role_id     INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table STONE.SYS_RELATION
  add primary key (RELATION_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

INSERT INTO sys_relation VALUES (1, 105, 1);
INSERT INTO sys_relation VALUES (2, 106, 1);
INSERT INTO sys_relation VALUES (3, 107, 1);
INSERT INTO sys_relation VALUES (4, 108, 1);
INSERT INTO sys_relation VALUES (5, 109, 1);
INSERT INTO sys_relation VALUES (6, 110, 1);
INSERT INTO sys_relation VALUES (7, 111, 1);
INSERT INTO sys_relation VALUES (8, 112, 1);
INSERT INTO sys_relation VALUES (9, 113, 1);
INSERT INTO sys_relation VALUES (10, 165, 1);
INSERT INTO sys_relation VALUES (11, 166, 1);
INSERT INTO sys_relation VALUES (12, 167, 1);
INSERT INTO sys_relation VALUES (13, 114, 1);
INSERT INTO sys_relation VALUES (14, 115, 1);
INSERT INTO sys_relation VALUES (15, 116, 1);
INSERT INTO sys_relation VALUES (16, 117, 1);
INSERT INTO sys_relation VALUES (17, 118, 1);
INSERT INTO sys_relation VALUES (18, 162, 1);
INSERT INTO sys_relation VALUES (19, 163, 1);
INSERT INTO sys_relation VALUES (20, 164, 1);
INSERT INTO sys_relation VALUES (21, 119, 1);
INSERT INTO sys_relation VALUES (22, 120, 1);
INSERT INTO sys_relation VALUES (23, 121, 1);
INSERT INTO sys_relation VALUES (24, 122, 1);
INSERT INTO sys_relation VALUES (25, 150, 1);
INSERT INTO sys_relation VALUES (26, 151, 1);
INSERT INTO sys_relation VALUES (27, 128, 1);
INSERT INTO sys_relation VALUES (28, 134, 1);
INSERT INTO sys_relation VALUES (29, 158, 1);
INSERT INTO sys_relation VALUES (30, 159, 1);
INSERT INTO sys_relation VALUES (31, 130, 1);
INSERT INTO sys_relation VALUES (32, 131, 1);
INSERT INTO sys_relation VALUES (33, 135, 1);
INSERT INTO sys_relation VALUES (34, 136, 1);
INSERT INTO sys_relation VALUES (35, 137, 1);
INSERT INTO sys_relation VALUES (36, 152, 1);
INSERT INTO sys_relation VALUES (37, 153, 1);
INSERT INTO sys_relation VALUES (38, 154, 1);
INSERT INTO sys_relation VALUES (39, 132, 1);
INSERT INTO sys_relation VALUES (40, 138, 1);
INSERT INTO sys_relation VALUES (41, 139, 1);
INSERT INTO sys_relation VALUES (42, 140, 1);
INSERT INTO sys_relation VALUES (43, 155, 1);
INSERT INTO sys_relation VALUES (44, 156, 1);
INSERT INTO sys_relation VALUES (45, 157, 1);
INSERT INTO sys_relation VALUES (46, 133, 1);
INSERT INTO sys_relation VALUES (47, 160, 1);
INSERT INTO sys_relation VALUES (48, 161, 1);
INSERT INTO sys_relation VALUES (49, 141, 1);
INSERT INTO sys_relation VALUES (50, 142, 1);
INSERT INTO sys_relation VALUES (51, 143, 1);
INSERT INTO sys_relation VALUES (52, 144, 1);
INSERT INTO sys_relation VALUES (53, 171, 1);
INSERT INTO sys_relation VALUES (54, 149, 1);
INSERT INTO sys_relation VALUES (55, 172, 1);
INSERT INTO sys_relation VALUES (56, 145, 1);
INSERT INTO sys_relation VALUES (57, 105, 5);
INSERT INTO sys_relation VALUES (58, 106, 5);
INSERT INTO sys_relation VALUES (59, 107, 5);
INSERT INTO sys_relation VALUES (60, 108, 5);
INSERT INTO sys_relation VALUES (61, 109, 5);
INSERT INTO sys_relation VALUES (62, 110, 5);
INSERT INTO sys_relation VALUES (63, 111, 5);
INSERT INTO sys_relation VALUES (64, 112, 5);
INSERT INTO sys_relation VALUES (65, 113, 5);
INSERT INTO sys_relation VALUES (66, 165, 5);
INSERT INTO sys_relation VALUES (67, 166, 5);
INSERT INTO sys_relation VALUES (68, 167, 5);
INSERT INTO sys_relation VALUES (69, 114, 5);
INSERT INTO sys_relation VALUES (70, 115, 5);
INSERT INTO sys_relation VALUES (71, 116, 5);
INSERT INTO sys_relation VALUES (72, 117, 5);
INSERT INTO sys_relation VALUES (73, 118, 5);
INSERT INTO sys_relation VALUES (74, 162, 5);
INSERT INTO sys_relation VALUES (75, 163, 5);
INSERT INTO sys_relation VALUES (76, 164, 5);
INSERT INTO sys_relation VALUES (77, 119, 5);
INSERT INTO sys_relation VALUES (78, 120, 5);
INSERT INTO sys_relation VALUES (79, 121, 5);
INSERT INTO sys_relation VALUES (80, 122, 5);
INSERT INTO sys_relation VALUES (81, 150, 5);
INSERT INTO sys_relation VALUES (82, 151, 5);
INSERT INTO sys_relation VALUES (83, 128, 5);
INSERT INTO sys_relation VALUES (84, 134, 5);
INSERT INTO sys_relation VALUES (85, 158, 5);
INSERT INTO sys_relation VALUES (86, 159, 5);
INSERT INTO sys_relation VALUES (87, 130, 5);
INSERT INTO sys_relation VALUES (88, 131, 5);
INSERT INTO sys_relation VALUES (89, 135, 5);
INSERT INTO sys_relation VALUES (90, 136, 5);
INSERT INTO sys_relation VALUES (91, 137, 5);
INSERT INTO sys_relation VALUES (92, 152, 5);
INSERT INTO sys_relation VALUES (93, 153, 5);
INSERT INTO sys_relation VALUES (94, 154, 5);
INSERT INTO sys_relation VALUES (95, 132, 5);
INSERT INTO sys_relation VALUES (96, 138, 5);
INSERT INTO sys_relation VALUES (97, 139, 5);
INSERT INTO sys_relation VALUES (98, 140, 5);
INSERT INTO sys_relation VALUES (99, 155, 5);
INSERT INTO sys_relation VALUES (100, 156, 5);
INSERT INTO sys_relation VALUES (101, 157, 5);
INSERT INTO sys_relation VALUES (102, 133, 5);
INSERT INTO sys_relation VALUES (103, 160, 5);
INSERT INTO sys_relation VALUES (104, 161, 5);
INSERT INTO sys_relation VALUES (105, 141, 5);
INSERT INTO sys_relation VALUES (106, 142, 5);
INSERT INTO sys_relation VALUES (107, 143, 5);
INSERT INTO sys_relation VALUES (108, 144, 5);

prompt
prompt Creating table SYS_ROLE
prompt =======================
prompt
create table STONE.SYS_ROLE
(
  role_id     INTEGER not null,
  pid         INTEGER,
  name        VARCHAR2(255),
  description VARCHAR2(255),
  sort        NUMBER(11),
  version     NUMBER(11),
  create_time DATE,
  update_time DATE,
  create_user INTEGER,
  update_user INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table STONE.SYS_ROLE
  add primary key (ROLE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

INSERT INTO sys_role VALUES (1, 0, '超级管理员', 'administrator', 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO sys_role VALUES (5, 1, '临时', 'temp', 2, NULL, NULL, NULL, NULL, NULL);

prompt
prompt Creating table SYS_USER
prompt =======================
prompt
create table STONE.SYS_USER
(
  user_id     INTEGER not null,
  avatar      VARCHAR2(255),
  account     VARCHAR2(45),
  password    VARCHAR2(45),
  salt        VARCHAR2(45),
  name        VARCHAR2(45),
  birthday    DATE,
  sex         VARCHAR2(10),
  email       VARCHAR2(45),
  phone       VARCHAR2(45),
  role_id     VARCHAR2(255),
  dept_id     INTEGER,
  status      VARCHAR2(32),
  create_time DATE,
  create_user INTEGER,
  update_time DATE,
  update_user INTEGER,
  version     NUMBER(11)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table STONE.SYS_USER
  add primary key (USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

INSERT INTO sys_user VALUES (1, '1', 'admin', '1d6b1208c7d151d335790276a18e3d99', 'q6taw', 'stone', NULL, 'M', NULL, '18200000000', '1', 27, 'ENABLE', NULL, NULL, NULL, 24, 25);

prompt
prompt Creating sequence SYS_DEPT_S
prompt ============================
prompt
create sequence STONE.SYS_DEPT_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 28
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_DICT_S
prompt ============================
prompt
create sequence STONE.SYS_DICT_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 63
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_FILE_INFO_S
prompt =================================
prompt
create sequence STONE.SYS_FILE_INFO_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 2
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_LOGIN_LOG_S
prompt =================================
prompt
create sequence STONE.SYS_LOGIN_LOG_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_MENU_S
prompt ============================
prompt
create sequence STONE.SYS_MENU_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 173
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_NOTICE_S
prompt ==============================
prompt
create sequence STONE.SYS_NOTICE_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 9
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_OPERATION_LOG_S
prompt =====================================
prompt
create sequence STONE.SYS_OPERATION_LOG_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_RELATION_S
prompt ================================
prompt
create sequence STONE.SYS_RELATION_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 108
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_ROLE_S
prompt ============================
prompt
create sequence STONE.SYS_ROLE_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 6
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_USER_S
prompt ============================
prompt
create sequence STONE.SYS_USER_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 2
increment by 1
cache 20;

