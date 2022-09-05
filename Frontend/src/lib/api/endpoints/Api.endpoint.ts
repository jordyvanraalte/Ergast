export default class ApiEndpoint {
    baseUrl = " http://localhost:8080";
    apiKey = "MY_API_KEY"
    constructor() {
        this.baseUrl = process.env.API_URL || this.baseUrl;
        this.apiKey = process.env.API_KEY || this.apiKey;
    }
}
