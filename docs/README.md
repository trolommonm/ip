# Duke User Guide
When the program starts, you will be greeted with:
```
 ____        _        
|  _ \ _   _| | _____ 
| | | | | | | |/ / _ \
| |_| | |_| |   <  __/
|____/ \__,_|_|\_\___|

	____________________________________________________________
	Hello! I'm Duke
	What can I do for you?
	____________________________________________________________
```

## Features 
1. List 
2. Bye
3. Done
4. Delete
5. Find
6. Todo
7. Deadline
8. Event

### Feature 1: List
Lists all the tasks currently inside Duke

#### Usage:
Example of usage: 

`list`

Expected outcome:

```
list
	____________________________________________________________
	1. [D][✓] project (by: 9pm)
	2. [T][✘] read book
	3. [D][✘] return book (by: June 6th)
	____________________________________________________________
```

### Feature 2: Bye
Exits the program

#### Usage:
Example of usage: 

`Bye`

Expected outcome:

```
bye
	____________________________________________________________
	Bye. Hope to see you again soon!
	____________________________________________________________
```

### Feature 3: Done
Marks the task as done

#### Usage:
Example of usage (without the parenthesis): 

`done (index of task)`

Expected outcome:

```
done 2
    ____________________________________________________________
    Nice! I've marked this task as done:
    [T][✓] read book
    ____________________________________________________________
```

### Feature 4: Delete
Deletes the task

#### Usage:
Example of usage (without the parenthesis): 

`delete (index of task)`

Expected outcome:

```
delete 2
	____________________________________________________________
	Noted. I've removed this task:
	[T][✓] read book
	Now you have 2 in the list.
	____________________________________________________________
```

### Feature 5: Find
Find tasks with matching keyword

#### Usage:
Example of usage (without the parenthesis): 

`find (matching keyword)`

Expected outcome:

```
find book
	____________________________________________________________
	Here are the matching tasks in your list:
	1. [D][✘] return book (by: June 6th)
	2. [T][✘] read book
	____________________________________________________________
```

### Feature 6: Todo
Add a todo task into your task list

#### Usage:
Example of usage (without the parenthesis): 

`todo (description of todo task)`

Expected outcome:

```
todo wash your laundry!
	____________________________________________________________
	Got it. I've added this task:
	[T][✘] wash your laundry!
	Now you have 4 tasks in the list.
	____________________________________________________________
```

### Feature 7: Deadline
Add a deadline task into your task list

#### Usage:
Example of usage (without the parenthesis): 

`deadline (description of deadline) /by (deadline of deadline task)`

Expected outcome:

```
deadline ip project /by 2359
	____________________________________________________________
	Got it. I've added this task:
	[D][✘] ip project (by: 2359)
	Now you have 5 tasks in the list.
	____________________________________________________________
```

### Feature 8: Event
Add an event task into your task list

#### Usage:
Example of usage (without the parenthesis): 

`event (description of event) /at (duration/timing of event)`

Expected outcome:

```
event wedding ceremony /at This Saturday 7pm
	____________________________________________________________
	Got it. I've added this task:
	[E][✘] wedding ceremony (at: This Saturday 7pm)
	Now you have 6 tasks in the list.
	____________________________________________________________
```



