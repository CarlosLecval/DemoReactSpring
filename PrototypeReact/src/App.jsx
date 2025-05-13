import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [products, setProducts] = useState([]);

  const fetchProducts = async () => {
    const response = await fetch(`http://localhost:8080/products?size=10`);
    const data = await response.json();
    setProducts(data);
  };

  useEffect(() => {
    console.log(products);
  }, [products]);

  useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <div className="main">
      <h1>E-commerce demo</h1>

      {products.map(product =>
        <div className='product' key={product.id}>
          <img src={product.imageUrl} style={{ width: '300px', borderRadius: '12px 12px 0px 0px'}}/>
          <div className='product-details'>
            <p className='product-name'>{product.name}</p>
            <p className='product-price'>${product.price}</p>
          </div>
        </div>
      )}
    </div>
  )
}

export default App
