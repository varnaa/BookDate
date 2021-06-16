import React, { Component } from 'react'

export default class Profile extends Component {
    constructor(props){
        super(props);
        this.state={
            
        }

        handleChange = (event) => {
            this.setState({ [event.target.name]: event.target.value });
        };
    }
    render() {
        return (
            <div>
                
            </div>
        )
    }
}
