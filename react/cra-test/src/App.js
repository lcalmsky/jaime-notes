import React from 'react';
import logo from './logo.svg';
import './App.css';
import TodoList from './TodoList';
import './test.css';

console.log(`NODE_ENV = ${process.env.NODE_ENV}`);
console.log(`REACT_APP_DATA_API = ${process.env.REACT_APP_DATA_API}`);

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>
                    Test
                </p>
                <a
                  className="App-link"
                  href="https://reactjs.org"
                  target="_blank"
                  rel="noopener noreferrer"
              >
                  Learn React
              </a>
              <TodoList/>
          </header>
      </div>
  );
}

export default App;
