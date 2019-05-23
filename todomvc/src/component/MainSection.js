import React, {Component} from 'react'
import TodoItem from './TodoItem'

export default class MainSection extends Component {

  render() {
    return (
      <section className="main">
        <ul className="todo-list">
          {this.props.todos.map(todo =>
            <TodoItem key={todo.id} todo={todo} />
          )}
        </ul>
      </section>
    )
  }
}
