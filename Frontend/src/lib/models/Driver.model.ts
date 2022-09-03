import Competitor from "./Competitor.model";

export default class Driver extends Competitor{
    constructor(public driverId: string,
                public permanentNumber: string,
                public code: string,
                public url: string,
                public givenName: string,
                public familyName: string,
                public dateOfBirth: string,
                public nationality: string
    ) {
        super();
    }

    getDisplayName(): string {
        return this.givenName + " " + this.familyName;
    }
}
