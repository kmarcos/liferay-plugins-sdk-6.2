create table training_Todo (
	todoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	taskDescription VARCHAR(75) null,
	finished BOOLEAN,
	createdDate DATE null,
	finishedDate DATE null
);

create table training_todo (
	todoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	taskDescription VARCHAR(75) null,
	finished BOOLEAN,
	createdDate DATE null,
	finishedDate DATE null
);