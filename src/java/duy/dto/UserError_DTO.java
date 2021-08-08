/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.dto;

/**
 *
 * @author くろくん
 */
public class UserError_DTO {
    private String usernameError;
    private String passwordError;
    private String fullnameError;
    private String roleError;

    public UserError_DTO() {
    }

    public UserError_DTO(String usernameError, String passwordError, String fullnameError, String roleError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.fullnameError = fullnameError;
        this.roleError = roleError;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    public String getRoleError() {
        return roleError;
    }

    public void setRoleError(String roleError) {
        this.roleError = roleError;
    }
    
    
}
