drop table t_lcm_service_segment if exists;

create table t_lcm_service_segment
(
    serviceId    varchar(255) not null,
	serviceSegmentId varchar(255) not null,
	serviceSegmentName  varchar(255) ,
	templateId varchar(255) not null,
	nodeType varchar(255) not null,
	owner varchar(255) not null,
	topoSeqNumber int not null,
	constraint pk_t_segments primary key(serviceId, serviceSegmentId)
);

insert into t_lcm_service_segment (serviceId,serviceSegmentId,serviceSegmentName,templateId,nodeType,owner,topoSeqNumber) 
VALUES('1', '12345', 'pop service', '12345', 'tosaca.nfv.node.POP', 'nfv', 1);