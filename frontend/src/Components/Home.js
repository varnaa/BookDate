import React, { Component } from 'react'
import Navigationbar from './Navigationbar';

export default class Home extends Component {
    constructor(props){
        super(props);
        this.state={

        }
    }
        redirect = (planCode)=>{
            window.location.replace("/checkout/"+planCode);
            
        }
    
    render() {
        return (
            <div>
                <Navigationbar></Navigationbar>
            <section class="u-align-center u-clearfix u-section-2" id="sec-f27e"> 
             <div class="u-clearfix u-sheet u-sheet-1">
            <h2 class="u-text u-text-1">Our Prices</h2>
            <p class="u-text u-text-2">Treat yourself with the book boxes that best suits you :)</p>
            <div class="u-clearfix u-expanded-width u-gutter-50 u-layout-wrap u-layout-wrap-1">
            <div class="u-layout">
                <div class="u-layout-row">
                <div class="u-container-style u-layout-cell u-size-20 u-size-20-md u-layout-cell-2">
                    <div class="u-border-2 u-border-palette-1-base u-container-layout u-valign-bottom u-container-layout-2">
                    <h4 class="u-align-center u-text u-text-6">READER</h4>
                    <h3 class="u-align-center u-text u-text-7">Rs 499</h3>
                    <p class="u-align-center u-text u-text-8">1 Random Book<br/>1 Bookmarks<br/>
                    </p>
                    <button href="" class="u-btn u-btn-round u-button-style u-hover-palette-2-base u-radius-50 u-btn-2" onClick={()=>this.redirect("reader")}>Order Now</button>
                    </div>
                </div>
                <div class="u-container-style u-layout-cell u-size-20 u-size-20-md u-layout-cell-2">
                    <div class="u-border-2 u-border-palette-1-base u-container-layout u-valign-bottom u-container-layout-2">
                    <h4 class="u-align-center u-text u-text-6">AVID READER</h4>
                    <h3 class="u-align-center u-text u-text-7">Rs 999</h3>
                    <p class="u-align-center u-text u-text-8">2 Random Books<br/>2 Bookmarks<br/>3 Scented Candles
                    </p>
                    <button href="" class="u-btn u-btn-round u-button-style u-hover-palette-2-base u-radius-50 u-btn-2" onClick={()=>this.redirect("avid-reader")}>Order Now</button>
                    </div>
                </div>
                <div class="u-align-center u-container-style u-layout-cell u-right-cell u-size-20 u-size-20-md u-white u-layout-cell-3">
                    <div class="u-border-2 u-border-palette-1-base u-container-layout u-valign-bottom u-container-layout-3">
                    <h4 class="u-text u-text-9">BIBLOPHILE</h4>
                    <h3 class="u-text u-text-10">Rs 1999</h3>
                    <p class="u-text u-text-11">3 Random Books<br/>3 Bookmarks<br/>2 Scented Candles<br/>1 Small Box of Book Merchandise<br/>( pens, badges, stickers)<br/></p>
                    <button class="u-btn u-btn-round u-button-style u-palette-1-base u-radius-50 u-btn-3" onClick={()=>this.redirect("biblophile")}>
                        Order Now</button>
                    </div>
                </div>
                </div>
                </div>
                </div>
            </div>
            </section>
        </div>
        )
    }
}
