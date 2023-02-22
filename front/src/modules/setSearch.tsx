const SEARCH = 'search' as const;

export const setSEARCH = (enter: boolean, title: string) => ({
  type: SEARCH,
  enter,
  title,
});

type state = {
  enter: boolean;
  title: string;
};

type setSearchAction = ReturnType<typeof setSEARCH>;

const initialState: state = {
  enter: false,
  title: '',
};

const setSearch = (state: state = initialState, action: setSearchAction) => {
  switch (action.type) {
    case SEARCH:
      return { ...state, enter: action.enter, title: action.title };
    default:
      return state;
  }
};

export default setSearch;
