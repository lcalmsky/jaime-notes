import React, {Component} from "react";
import {BrowserRouter, Link, Route} from 'react-router-dom';
import Rooms from './Rooms'

class App extends Component {
    render() {
        return (
            <BrowserRouter>
                <div style={{padding: 20, border: '5px solid gray'}}>
                    <Link to="/">홈</Link>
                    <br/>
                    <Link to="/photo">사진</Link>
                    <br/>
                    <Link to="/rooms">방 소개</Link>
                    <br/>
                    <Route exact path="/" component={Home}/>
                    <Route path="/photo" component={Photo}/>
                    <Route path="/rooms" component={Rooms}/>
                </div>
            </BrowserRouter>
        );

        function Home() {
            return <h2>여기는 홈페이지입니다.</h2>
        }

        function Photo() {
            return <h2>여기서 사진을 감상하세요.</h2>
        }
    }
}

export default App;