import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const globalStyles = createGlobalStyle`
    ${reset}
    * {
        background-color: black;
        color : white;
    }
    * {
        -ms-overflow-style: none; 
        scrollbar-width: none; 
    }
    *::-webkit-scrollbar {
        display: none; 
    }
`;

export default globalStyles;
