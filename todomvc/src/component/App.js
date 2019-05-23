import React, { Component } from 'react';
import Header from './Header';
import MainSection from './MainSection'

const initialState = [
  {
    text: 'React ES6 TodoMVC',
    completed: false,
    id: 0
  }
]

class App extends Component {
  state = {
    todos: initialState
  }

  onSave(text) {
    const todos = [
      {
        id: this.state.todos.reduce((maxId, todo) => Math.max(todo.id, maxId), -1) + 1,
        completed: false,
        text: text
      },
      ...this.state.todos
    ]
    this.setState({todos})
  }

  render() {
    return (
      <div>
        <Header
          onSave={this.onSave.bind(this)}
        />
        <MainSection todos={this.state.todos}/>
      </div>
    );
  }
}

export default App;
