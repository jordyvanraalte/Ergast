export default class Race {
    public round: string
    public url: string
    public raceName: string
    public date: string
    public time: string


    constructor(round: string, url: string, raceName: string, date: string, time: string) {
        this.round = round;
        this.url = url;
        this.raceName = raceName;
        this.date = date;
        this.time = time;
    }
}
