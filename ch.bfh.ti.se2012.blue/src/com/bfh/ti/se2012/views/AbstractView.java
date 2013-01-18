/**
 * The class AbstractView is a low coupling for all Views
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.views;

import com.vaadin.ui.CustomComponent;



public abstract class AbstractView extends CustomComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected abstract void close() throws Exception;

}

