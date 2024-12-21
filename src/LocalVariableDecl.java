// =================================================================================================================================
public class LocalVariableDecl extends VariableDeclaration {
// =================================================================================================================================



    // =================================================================================================================================
    // DATA MEMBERS

    /** The offset into the stack from the frame/base pointer at which this variable resides. */
    private int _offset;
    // =================================================================================================================================



    // =================================================================================================================================
    /**
     * Create a new local variable declaration.
     *
     * @param token The token use declare the variable name.
     * @param type  The data type of the variable.
     */
    public LocalVariableDecl (Token token, Type type) {
	
	super(token, type);
	_offset = -1;      // Default value is negative as easy check to see that it has not been set yet
	
    } // LocalVariableDecl
    // =================================================================================================================================
    


    // =================================================================================================================================
    /**
     * Provide assembly for access to the global variable.  It is accessed via offset from rbp.
     *
     * @return assemly for accessing this variable.
     */
    public String toAssembly () {

	return "[rbp + " + _offset + "]";
	
    } // toAssembly ()
    // =================================================================================================================================


 
    // =================================================================================================================================
    /**
     * Generate assembly to use this variable as an l-value.
     */
    public String toAssembly_l () {

	String assembly = ( "\tmov\trax,\t" + _offset + "\t; Offset of " + _name + "\n" +
			    "\tadd\trax,\trbp\t; Address of " + _name + "\n" +
			    "\tpush\trax\n" );
    
	return assembly;
	
    } // toAssembly_l ()
    // =================================================================================================================================
    
    
    // =================================================================================================================================
    /**
     * Generate no static code as local variables are located on the stack
     */
    public String toStatics() {
        return new String();
    }
    // =================================================================================================================================


    // =================================================================================================================================
    public int getOffset () {
	
	return _offset;
	
    } // getOffset ()
    // =================================================================================================================================


    
    // =================================================================================================================================
    public void setOffset (int offset) {

	_offset = offset;
	
    } // setOffset ()
    // =================================================================================================================================

    
// =================================================================================================================================
} // class LocalVariableDecl
// =================================================================================================================================