package flight

type Flight struct {
    Key            string `json:"key"`
    Pos            string `json:"pos"`
    Manual         bool   `json:"manual"`
    CampaignFare      bool     `json:"campaignFare"`
    CampaignCode      string   `json:"campaignCode"`
    SaleStart      string `json:"saleStart"`
    SaleEnd        string `json:"saleEnd"`
    SearchDateTime string `json:"searchDateTime"`
    Season         string `json:"season"`
    AdvPurchPeriod    string `json:"advPurchPeriod"`
    Opaque         bool `json:"opaque"`
    BookByDates    string `json:"bookByDates"`
    TicketType    string   `json:"ticketType"`
    Stay          string   `json:"stay"`
    FlightType    string   `json:"flightType"`
    FlightTicketType    string   `json:"flightTicketType"`
    Duration      string   `json:"duration"`
    DepartureDate string   `json:"departureDate"`
    ReturnDate    string   `json:"returnDate"`
    Eligibility   string   `json:"eligibility"`
    Stopovers     []string `json:"stopovers"`
    Direct        bool     `json:"direct"`
    Restrictions  bool     `json:"restrictions"`
    Exclusive     bool     `json:"exclusive"`
    Layby         bool     `json:"layby"`
    Multiflex     bool     `json:"multiflex"`
    TopOffer      string   `json:"topOffer"`
    URLDeep       string   `json:"urlDeep"`
    Dest           struct {
        Region  string `json:"region"`
        Country string `json:"country"`
        City    string `json:"city"`
        Iata    string `json:"iata"`
    } `json:"dest"`
    Origin struct {
        City string `json:"city"`
        Iata string `json:"iata"`
    } `json:"origin"`
    Fare struct {
            Currency string   `json:"currency"`
            Net     float64  `json:"net"`
            Q        float64  `json:"qCharges"`
            YQ       float64  `json:"yqTaxes"`
            Booking  float64  `json:"bookingFees"`
            Total    float64  `json:"total"`
            Type     []string `json:"type"`
    } `json:"fare"`
    Segments       []struct {
    LeaveDate       string      `json:"leaveDate"`
    ArriveDate      string      `json:"arriveDate"`
    Origin          string      `json:"origin"`
    Destination     string      `json:"destination"`
    Cabin           string      `json:"cabin"`
    CabinCode       string      `json:"cabinCode"`
    FlightNumber    string      `json:"flightNumber"`
    MarkAirline     string      `json:"markAirline"`
    OpAirline       string      `json:"opAirline"`
    Aircraft        string      `json:"aircraft"`
    } `json:"segments"`
}
