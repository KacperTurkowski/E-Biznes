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

const StartPage = ()=>{
    const [categories, setCategories] = useState([]);
    const [value, setValue] = useState(0);

    const changeTab = (event, newValue) => {
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
            <h1>Twój sklep</h1>
            <CartButton/>
            <UserButton/>
            <HomeButton/>
            <div id="div" className="mainPanel">
                <Box >
                    <Tabs
                        value={value}
                        onChange={changeTab}
                        variant="scrollable"
                        scrollButtons="auto"
                        aria-label="scrollable auto tabs example"
                    >
                        <Tab label="Strona startowa"></Tab>
                        {
                            categories.map((category, index)=>(
                                <Tab key={index} label={category.name} {...a11yProps(category.id)} />
                            ))
                        }

                    </Tabs>
                    {
                        categories.map((category, index)=>(
                            <TabPanel value={value} index={index} />
                        ))
                    }
                </Box>

            </div>
        </>
    )
}
export default StartPage;