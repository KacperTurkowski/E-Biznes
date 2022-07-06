import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import {useEffect, useState} from "react";
import Repository from "../../Repository";

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
    console.log(categories)
    return(
        <>
            <Tabs
                value={value}
                onChange={changeTab}
                variant="scrollable"
                scrollButtons="auto"
                aria-label="scrollable auto tabs example"
            >
                {
                    categories.map((category, index)=>(
                        <Tab key={index} label={category.name} />
                    ))
                }

            </Tabs>
        </>
    )
}
export default StartPage;