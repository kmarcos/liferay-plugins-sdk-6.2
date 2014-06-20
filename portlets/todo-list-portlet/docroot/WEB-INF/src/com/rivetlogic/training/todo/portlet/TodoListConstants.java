package com.rivetlogic.training.todo.portlet;

public class TodoListConstants {
    
    // Model Fields
    public static final String TODO_ID = "todoId";
    public static final String TODO_DESCRIPTION = "taskDescription";
    public static final String TODO_FINISHED = "finished";
    
    // Resources Names
    public static final String RESOURCE_MODEL = "com.rivetlogic.training.todo.model";
    public static final String RESOURCE_TODO_MODEL = "com.rivetlogic.training.todo.model.Todo";

    // Resource Permissions
    public static final String PERMISION_ADD_TODO = "ADD_TODO";
    
    // Success Messages
    public static final String SUCCESS_TODO_ADDED = "todo-added";
    public static final String SUCCESS_TODO_UPDATED = "todo-updated";
    
    // Error Messages
    public static final String ERROR_PERMISSION = "permission-error";
    public static final String ERROR_TASK_DECRIPTION_REQUIRED = "task-description-required";
}
