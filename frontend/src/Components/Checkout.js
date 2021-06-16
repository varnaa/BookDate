import React, { Component } from "react";
import Navbar from "./Navbar";
export default class Checkout extends Component {
	constructor(props) {
		super(props);
		this.state = {};
	}
	render() {
		return (
			<div>
				<Navbar></Navbar>
				<section className="u-clearfix u-section-1" id="sec-a116">
					<div className="u-clearfix u-sheet u-sheet-1">
						<div className="u-align-center u-container-style u-expanded-width u-product u-product-1">
							<div className="u-container-layout u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xs u-container-layout-1">
								<h1>Product Title</h1>
								<div className="u-product-control u-product-variations u-product-variations-1">
									<div className="u-product-variant">
										<label for="product-variant-select-1" className="u-label">
											Quantity
										</label>
										<div className="u-form-select-wrapper">
											<select
												id="product-variant-select-1"
												className="u-border-1 u-border-grey-30 u-input u-input-rectangle u-radius-50 u-white"
											>
												<option name="quantity" value="1">
													1
												</option>
												<option name="quantity" value="2">
													2
												</option>
												<option name="quantity" value="3">
													3
												</option>
											</select>
											<svg
												xmlns="http://www.w3.org/2000/svg"
												width="14"
												height="12"
												version="1"
												className="u-caret"
											>
												<path fill="currentColor" d="M4 8L0 4h8z"></path>
											</svg>
										</div>
									</div>
								</div>
								<div className="u-product-control u-product-variations u-product-variations-2">
									<div className="u-product-variant">
										<label for="product-variant-select-1" className="u-label">
											Add ons
										</label>
										<div className="u-form-select-wrapper">
											<select
												id="product-variant-select-1"
												className="u-border-1 u-border-grey-30 u-input u-input-rectangle u-radius-50 u-white"
												name="addon_code"
											>
												<option value="None">None</option>
												<option value="code1">2 - Extra Scented candles</option>
												<option value="code2">
													1 small box of book merchandise
												</option>
												<option value="code3">
													1 big box of book merchandise
												</option>
											</select>
											<svg
												xmlns="http://www.w3.org/2000/svg"
												width="14"
												height="12"
												version="1"
												className="u-caret"
											>
												<path fill="currentColor" d="M4 8L0 4h8z"></path>
											</svg>
										</div>
									</div>
								</div>
								<div className="u-product-control u-product-variations u-product-variations-3">
									<div className="u-product-variant">
										<label for="product-variant-select-1" className="u-label">
											Add On Type
										</label>
										<div className="u-form-select-wrapper">
											<select
												id="product-variant-select-1"
												className="u-border-1 u-border-grey-30 u-input u-input-rectangle u-radius-50 u-white"
											>
												<option name="type" value="one_time">
													One Time
												</option>
												<option name="type" value="recurirng">
													Recurring
												</option>
											</select>
											<svg
												xmlns="http://www.w3.org/2000/svg"
												width="14"
												height="12"
												version="1"
												className="u-caret"
											>
												<path fill="currentColor" d="M4 8L0 4h8z"></path>
											</svg>
										</div>
									</div>
								</div>
								<div className="u-product-control u-product-variations u-product-variations-4">
									<div className="u-product-variant">
										<label for="product-variant-select-1" className="u-label">
											Subscripton Type
										</label>
										<div className="u-form-select-wrapper">
											<select
												id="product-variant-select-1"
												className="u-border-1 u-border-grey-30 u-input u-input-rectangle u-radius-50 u-white"
											>
												<option name="billing_cycles" value="1">
													{" "}
													One Time{" "}
												</option>
												<option name="billing_cycles" value="3">
													{" "}
													Quaterly{" "}
												</option>
												<option name="billing_cycles" value="6">
													{" "}
													Half Yearly{" "}
												</option>
												<option name="billing_cycles" value="12">
													{" "}
													Yearly{" "}
												</option>
											</select>
											<svg
												xmlns="http://www.w3.org/2000/svg"
												width="14"
												height="12"
												version="1"
												className="u-caret"
											>
												<path fill="currentColor" d="M4 8L0 4h8z"></path>
											</svg>
										</div>
									</div>
								</div>
								<a
									href="#"
									className="u-black u-btn u-button-style u-product-control u-btn-1"
								>
									SUBSCRIBE
								</a>
							</div>
						</div>
					</div>
				</section>
			</div>
		);
	}
}
