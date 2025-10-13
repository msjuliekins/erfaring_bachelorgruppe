import IMerch from "../../interfaces/IMerch";

const MerchItem: React.FC<IMerch> = ({name, image, price}) => {

    const imagePath = `http://localhost:5229/images/${image}`;

    return (
        <article>
            <h3 className="heading">{name}</h3>
            <img src={imagePath} className="img-fluid rounded" style={{ width: "150px", height: "200px", objectFit: "cover" }} alt={`Photo of product:${name}`}/>
            <p>${price}</p>
        </article>
    );
};

export default MerchItem;
