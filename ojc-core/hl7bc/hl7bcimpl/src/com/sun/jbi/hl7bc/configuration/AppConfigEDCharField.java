package com.sun.jbi.hl7bc.configuration;

import javax.management.openmbean.SimpleType;

import com.sun.jbi.hl7bc.extensions.HL7ProtocolProperties;

public class AppConfigEDCharField extends ApplicationConfigurationField {
    private static final String INITIAL_VALUE = HL7ProtocolProperties.END_DATA_CHAR.toString();
    
    private Integer value = Integer.valueOf(INITIAL_VALUE);

    AppConfigEDCharField() {
        super("endDataCharacter", "End Data Char", SimpleType.INTEGER);
    }

    public String toString() {
        return value.toString();
    }

    public void fromString(String data) {
        Integer ivalue;
        try {
            ivalue = Integer.valueOf(data);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        
        value = ivalue;
    }

    public Object clone() {
    	AppConfigEDCharField clone = new AppConfigEDCharField();
        clone.setValue(getValue());
        return clone;
    }

    /**
     * Validate the data against the field.
     *
     * @return If there are no errors, this validation should return null or
     *         an empty array.  If there are correctable errors, this validation
     *         must return an array with one element that is the corrective
     *         value. Otherwise, an array of one or more strings describing the
     *         validation failure(s) must be returned, with the first element
     *         in array being <code>null</code>.
     */
    public Object[] validate(Object value) {
        // Check against bad type
        /*if (value != null && !(value instanceof Integer)) {
            return new String[] {
                    null,
                    "Invalid value type, expected java.lang.Integer, got: "
                            + value.getClass().getName(),
            };
        }*/
        
        Object[] ret = null;
        
        // Check against null
        if (value == null || value.toString().trim().length() == 0) {
            ret = new Object[] {Integer.valueOf(INITIAL_VALUE)};
            return ret;
        }
        
        if (value != null) {
            Byte val = Byte.valueOf(value.toString().trim());
            if (val < 1 || val > 127) {
                ret = new String[]{
                        null,
                        "Invalid value " + val + ". Valid inclusive range is between 1 and 127. Should be specified in decimal. Default is " + HL7ProtocolProperties.END_DATA_CHAR
                };
            }
        }
        
        return ret;
    }

    /**
     * Assign a value to this field. Implements can assume that the supplied
     * value has already been validated thru a {@link #validate} call.
     * 
     * @throws ClassCastException if the runtime type of the value is invalid
     *         for the field. 
     */
    public void setValue(Object value) throws ClassCastException {
        this.value = (value != null ?  (Integer)value : Integer.valueOf(INITIAL_VALUE));
    }

    /**
     * Retrieve the value previously assigned to this field.
     *
     * @return Value previously assigned to this field, or <code>null</code>
     *         if no value has been
     */
    public Integer getValue() {
        return value;
    }
}
