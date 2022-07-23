import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import {useEffect, useState} from "react";
import Repository from "../../Repository";
import "./StartPage.css"
import CartButton from "../CartButton/CartButton";
import UserButton from "../UserButton/UserButton";
import HomeButton from "../HomeButton/HomeButton";
import Box from '@mui/material/Box';
import TabPanel from "../TabPanel/TabPanel";
import OrdersButton from "../OrdersButton/OrdersButton";

const StartPage = ()=>{
    const [categories, setCategories] = useState([]);
    const [value, setValue] = useState(0);

    const changeTab = (_event, newValue) => {
        setValue(newValue);
    };

    useEffect(() => {
        Repository
            .getCategories()
            .then(json => {
                setCategories(json)
            })
    }, []);

    function a11yProps(index) {
        return {
            id: `full-width-tab-${index}`,
            'aria-controls': `full-width-tabpanel-${index}`,
        };
    }

    return(
        <>
            <h1 id="shop-name">Twój sklep</h1>
            <CartButton/>
            <UserButton/>
            <HomeButton/>
            <OrdersButton/>
            <div id="div" className="mainPanel">
                <Box >
                    <Tabs
                        value={value}
                        onChange={changeTab}
                        variant="scrollable"
                        scrollButtons="auto"
                        aria-label="scrollable auto tabs example"
                    >
                        <Tab id="startPage" label="Strona startowa"></Tab>
                        {
                            categories.map((category, index)=>(
                                <Tab key={index} label={category.name} {...a11yProps(category.id)} />
                            ))
                        }

                    </Tabs>
                    {
                        categories.map((_category, index)=>(
                            <TabPanel id={'category_'+index} value={value} index={index} />
                        ))
                    }
                </Box>

            </div>
        </>
    )
}
export default StartPage;