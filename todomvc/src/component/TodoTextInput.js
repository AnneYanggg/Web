import React, {Component} from 'react'

export default class TodoTextInput extends Component {

  handleSubmit = e => {
    const text = e.target.value.trim()
    if (e.which === 13) {
      this.props.onSave(text)
    }
  }

  render() {
    return (
      <input className='new-todo'
             type="text"
             placeholder="What needs to be done?"
             autoFocus="true"
             onKeyDown={this.handleSubmit} />
    )
  }
}
