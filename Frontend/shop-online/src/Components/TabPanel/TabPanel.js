import Box from "@mui/material/Box";
import ProductPage from "../ProductPage/ProductPage";
import PropTypes from "prop-types";

const TabPanel = (props) => {
    const { children, value, index, ...other } = props;

    console.log(index)
    return (
        <div
            role="tabpanel"
            hidden={value !== index}
            id={`full-width-tabpanel-${index}`}
            aria-labelledby={`full-width-tab-${index}`}
            {...other}
        >
            {value === index && (
                <Box sx={{ p: 3 }}>
                    <ProductPage categoryId = {index}/>
                </Box>
            )}
        </div>
    );
}

TabPanel.propTypes = {
    children: PropTypes.node,
    index: PropTypes.number.isRequired,
    value: PropTypes.number.isRequired,
};

export default TabPanel;