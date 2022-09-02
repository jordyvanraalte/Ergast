export default class ApiEndpoint {
    baseUrl = " http://localhost:8080";
    constructor() {
        this.baseUrl = process.env.API_URL || this.baseUrl;
    }
}
