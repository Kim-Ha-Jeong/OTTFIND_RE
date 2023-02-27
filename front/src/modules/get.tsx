import axios from 'axios';

const API = process.env.API_URL;

const get = ({ pathname, params }: propsType) => {
  try {
    const result = axios.get(`${API}/${pathname}`, {
      params,
    });
    return result;
  } catch (err) {
    throw err;
  }
};

type propsType = {
  pathname: string;
  params?: Object | null;
};

export default get;
