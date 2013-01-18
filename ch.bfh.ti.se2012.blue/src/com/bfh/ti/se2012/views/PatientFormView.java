/**
 * The class PatientFormView display data SQL Patient
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.views;


import java.util.Arrays;

import com.bfh.ti.se2012.StartApplication;
import com.bfh.ti.se2012.components.Body;
import com.bfh.ti.se2012.data.Patient;
import com.vaadin.data.Item;
import com.vaadin.data.Validator;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;



public class PatientFormView extends AbstractView {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    Patient patient;
    Body layout = new Body();
    private static final String COMMON_FIELD_WIDTH = "12em";
    
    /**
	 * The constructor should first body structur and than add the actual view.
	 */
	public PatientFormView() {
		setHeight("100%");
		setWidth("768px");
		setCompositionRoot(layout);
		

	}


	/**
	 * this methode define the actual design of this view
	 */
	private VerticalLayout setView(Patient p1) {
		VerticalLayout view = new VerticalLayout();
		view.setMargin(false);
		view.setWidth("100%");
		view.setCaption("Patient Detail View");
		
		patient = p1; // a person POJO
	    BeanItem<Patient> personItem = new BeanItem<Patient>(patient); // item from
	                                                                // POJO

	    // Create the Form
	    final Form personForm = new Form();
	    personForm.setWriteThrough(false); // we want explicit 'apply'
	    personForm.setInvalidCommitted(false); // no invalid values in datamodel

	    // FieldFactory for customizing the fields and adding validators
	    personForm.setFormFieldFactory(new PersonFieldFactory());
	    personForm.setItemDataSource(personItem); // bind to POJO via BeanItem

	    // Determines which properties are shown, and in which order:
	    personForm.setVisibleItemProperties(Arrays.asList(new String[] {
	            "pid","firstName", "lastName","city", "address",
	            "birthdate", "phoneNumber", "mail", "healthInsuranceCompany"}));

	    // Add form to layout
	    view.addComponent(personForm);

	    // The cancel / apply buttons
	    HorizontalLayout buttons = new HorizontalLayout();
	    buttons.setSpacing(true);
	    Button discardChanges = new Button("Discard changes",
	            new Button.ClickListener() {
	                public void buttonClick(ClickEvent event) {
	                    //personForm.discard();
	                	StartApplication.getUiHandler().switchView("PatientView");
	                }
	            });
	    discardChanges.setStyleName("navButton");
	    buttons.addComponent(discardChanges);
	    buttons.setComponentAlignment(discardChanges, Alignment.MIDDLE_LEFT);

	    Button apply = new Button("Apply", new Button.ClickListener() {
	        public void buttonClick(ClickEvent event) {
	            try {
	                //personForm.commit();
	            	StartApplication.getUiHandler().switchView("PatientView");
	            } catch (Exception e) {
	                // Ignored, we'll let the Form handle the errors
	            }
	        }
	    });
	    apply.setStyleName("navButton");
	    buttons.addComponent(apply);
	    personForm.getFooter().addComponent(buttons);
	    personForm.getFooter().setMargin(false, false, true, true);

	    // button for showing the internal state of the POJO
	    Button showPojoState = new Button("Show POJO internal state",
	            new Button.ClickListener() {
	                public void buttonClick(ClickEvent event) {
	                    showPojoState();
	                }
	            });
	    view.addComponent(showPojoState);
	    
		return view;

	}

    

	private void showPojoState() {
	    Window.Notification n = new Window.Notification("POJO state",
	            Window.Notification.TYPE_TRAY_NOTIFICATION);
	    n.setPosition(Window.Notification.POSITION_CENTERED);
	    n.setDescription("PID: "+ patient.getPid()+"<br/>First name: " + patient.getFirstName()
	            + "<br/>Last name: " + patient.getLastName() + "<br/>City: "
	            + patient.getCity() + "<br/>Address:"
	            + patient.getAddress() + "<br/>Birthdate: "
	            + patient.getBirthdate() + "<br/>Phonenumber: "
	            + patient.getPhoneNumber() + "<br/>Mail: "
	            + patient.getMail() + "<br/>HealthInsuranceCompany:"
	            + patient.getHealthInsuranceCompany());
	    getWindow().showNotification(n);
	}

	private class PersonFieldFactory extends DefaultFieldFactory {

    final TextField address = new TextField("Address");

    @Override
    public Field createField(Item item, Object propertyId,
            Component uiContext) {
        Field f;
        if ("address".equals(propertyId)){
            // filtering ComboBox w/ country names
            return address;
        }  
        else {
            // Use the super class to create a suitable field base on the
            // property type.
            f = super.createField(item, propertyId, uiContext);
        }

        
        if ("pid".equals(propertyId)) {
        	TextField tf = (TextField) f;
        	tf.setRequired(true);
            tf.setNullRepresentation("");
            tf.setNullSettingAllowed(true);
            tf.addValidator(new IntegerValidator(
                    "PID must be an Integer"));
            tf.setWidth("10em");
        }
        else if ("firstName".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setRequired(true);
            tf.setRequiredError("Please enter a First Name");
            tf.setWidth(COMMON_FIELD_WIDTH);
            tf.addValidator(new StringLengthValidator(
                    "First Name must be 3-25 characters", 3, 25, false));
        } else if ("lastName".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setRequired(true);
            tf.setRequiredError("Please enter a Last Name");
            tf.setWidth(COMMON_FIELD_WIDTH);
            tf.addValidator(new StringLengthValidator(
                    "Last Name must be 3-50 characters", 3, 50, false));
        } else if ("city".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setRequired(true);
            tf.setRequiredError("Please enter city");
            tf.setWidth(COMMON_FIELD_WIDTH);
            tf.addValidator(new StringLengthValidator(
                    "City must be 3-50 characters", 3, 50, false));
        } 
        else if ("phoneNumber".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setRequired(true);
            tf.setNullRepresentation("");
            tf.setNullSettingAllowed(true);
            tf.addValidator(new IntegerValidator(
                    "Phonenumber must be an Integer"));
            tf.setWidth("10em");
        } else if ("mail".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setRequired(true);
            tf.setRequiredError("Please enter mail");
            tf.setWidth(COMMON_FIELD_WIDTH);
            tf.addValidator(new StringLengthValidator(
                    "Mail must be 3-50 characters", 3, 50, false));
        } else if ("healthInsuranceCompany".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setRequired(true);
            tf.setRequiredError("Please enter a Health Insurance Company");
            tf.setWidth(COMMON_FIELD_WIDTH);
            tf.addValidator(new StringLengthValidator(
                    "Health Insurance company Name must be 3-50 characters", 3, 50, false));
        } 

        return f;
    }
	}
    
    public class IntegerValidator implements Validator {

        private String message;

        public IntegerValidator(String message) {
            this.message = message;
        }

        public boolean isValid(Object value) {
            if (value == null || !(value instanceof String)) {
                return false;
            }
            try {
                Integer.parseInt((String) value);
            } catch (Exception e) {
                return false;
            }
            return true;
        }

        public void validate(Object value) throws InvalidValueException {
            if (!isValid(value)) {
                throw new InvalidValueException(message);
            }
        }

    }
    
    public void setPatient(Patient p1){
    	layout.removeBodyView();
    	layout.setBodySubView(this.setView(p1));
    }

	@Override
	protected void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
    
}
