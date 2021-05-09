package com.epam.programs_portal.mostly_used_variables;

import com.epam.program_portal.utility_functions.UserPropertiesUtilities;

public interface UserCredentials {

	String username = UserPropertiesUtilities.getUsername();
	String password = UserPropertiesUtilities.getPassword();
}
