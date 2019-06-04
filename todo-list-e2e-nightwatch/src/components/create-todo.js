import React from "react";

export default class CreateTodo extends React.Component {
    render () {
        return (
            <form onSubmit={this.onSubmit.bind(this)} className="create-todo-form">
<<<<<<< HEAD
                <input type="text" placeholder="Task" ref="taskMessage" id="task"  autoFocus/>
=======
                <input type="text" placeholder="Task" ref="taskMessage" id="task" autoFocus/>
>>>>>>> 3732cde203fd7e2680a23c23dcaddf732d8d1732
                <button id="add">Add</button>
            </form>
        );
    }
    onSubmit (e) {
        this.props.createTask(this.refs.taskMessage.value);
        this.refs.taskMessage.value = "";
        e.preventDefault();
    }
}
