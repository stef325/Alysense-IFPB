import ApiService, { LOGGED_USER, TOKEN } from "./ApiService";
import StorageService from "./StorageService";

export default class AuthenticationApiService extends ApiService{
    constructor(){
        super('');
        this.StorageService = new StorageService();

    }

    isTokenValid(token){
        return this.post('/isTokenValid', token);
    }

    async login(email, password){
        const userCredentials = {
            'email': email, 
            'password': password
        }

        try {
            const response = await this.post('/login', userCredentials);
            const user = response.data.user
            const token = response.data.token

            this.StorageService.setItem(LOGGED_USER, user)
            this.StorageService.setItem(TOKEN, token)

            this.registerToken(token)
            return user;

        } catch (error) {
            return null
            
        }
    }

    logout(){
        this.StorageService.removeItem(LOGGED_USER)
        this.StorageService.removeItem(TOKEN)
        return this.post("/logout")
    }

    getLoggedUser(){
        return this.StorageService.getItem(LOGGED_USER)
    }
    getToken(){
        return this.StorageService.getItem(TOKEN)
    }

    async isAuthenticated(){
        const user = this.getLoggedUser()
        const token = this.getToken()

        if (!user || !token) {
            return false
        }

        const tokenDTO = {
            "token": token
        }

        const response = await this.isTokenValid(tokenDTO)
        return response.data
    }

}