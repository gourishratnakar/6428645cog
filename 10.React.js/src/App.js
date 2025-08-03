import './App.css';

function App() {
  const heading = "Office Space";

  const offices = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai",
      image: "/office.jpg" // ✅ Local image from public folder
    },
    {
      Name: "Regus",
      Rent: 70000,
      Address: "Bangalore",
      image: "https://cdn.pixabay.com/photo/2017/03/30/12/43/meeting-2196941_960_720.jpg"
    }
  ];

  return (
    <div>
      <h1>{heading}, at Affordable Range</h1>
      {offices.map((item, index) => {
        const rentClass = item.Rent <= 60000 ? 'textRed' : 'textGreen';

        return (
          <div className="office-card" key={index}>
            <img
              src={item.image}
              width="25%"
              height="25%"
              alt="Office Space"
            />
            <h2>Name: {item.Name}</h2>
            <h3 className={rentClass}>Rent: Rs. {item.Rent}</h3>
            <h3>Address: {item.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}

export default App;
