import Competitor from "./Competitor.model";

export default class Constructor extends Competitor {
    constructor(public constructorId: string,
                public url: string,
                public name: string,
                public nationality: string)
    {
        super()
    }

    getDisplayName(): string {
        return this.name;
    }


}
