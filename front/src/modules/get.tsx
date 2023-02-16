import axios from 'axios';

const get = ({ pathname, params }: propsType) => {
  try {
    const result = axios.get(`${process.env.API_URL}/${pathname}`, {
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
